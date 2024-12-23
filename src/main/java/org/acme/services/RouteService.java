package org.acme.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Address;
import org.acme.AppUser;
import org.acme.Car;
import org.acme.Route;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.quarkus.agroal.runtime.AgroalConnectionConfigurer.log;

@ApplicationScoped
@Path("/route")
public class RouteService {
    private static final Logger log = LoggerFactory.getLogger(Route.class);

    @ConfigProperty(name = "mifahrapp.backend.routeServer")
    private String routeServer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createRoute(Route route) {
        try {
            //ToDo: Get the Route Length and endTime

            // Fetch the user and car using their IDs
            if (route.getUser() != null && route.getUser().id != null) {
                AppUser user = AppUser.findById(route.getUser().id);
                if (user == null) {
                    throw new Exception("User not found");
                }
                route.setUser(user);
            }

            if (route.getCar() != null && route.getCar().id != null) {
                Car car = Car.findById(route.getCar().id);
                if (car == null) {
                    throw new Exception("Car not found");
                }
                route.setCar(car);
            }

            // Persist the route
            route.persist();
            return Response.ok(route).build();

        } catch (Exception e) {
            log.error("Error creating route", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Failed to create route,\"," +
                            "\"message\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoute(@QueryParam("id") int id){
        Route rt;
        try {
            rt = Route.findById(id);
            if (rt == null){
                throw new Exception("Route not found");
            }
        } catch (Exception e) {
            log.error("Error creating route", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Failed or no Route with that id,\"," +
                            "\"message\": \"" + e.getMessage() + "\"}")
                    .build();
        }
        return Response.ok(rt).build();
    }


    @Path("routesoldAndPropUseless")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response test() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().
                    uri(new URI(routeServer + "/route/v1/driving/9.67571701537255,50.869555265681626;9.739225656843843,50.98777171601268?geometries=geojson")).
                    GET().build();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body().toString());
            JsonNode routeGeometry = rootNode.path("routes").get(0).path("geometry");

            // Extract coordinates and type
            JsonNode coordinates = routeGeometry.path("coordinates");
            String type = routeGeometry.path("type").asText();

            // Create the output JSON structure
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode geometryNode = mapper.createObjectNode();
            geometryNode.put("type", type);
            geometryNode.set("coordinates", coordinates);

            ObjectNode resultNode = mapper.createObjectNode();



            return Response.status(response.statusCode()).entity(geometryNode.toString()).build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(500).entity("Fehlermeldung aus RouteTest hier übergeben").build();
        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/route")
    public Response getDistance(
            @QueryParam("startLat") Double startLat,
            @QueryParam("startLong") Double startLong,
            @QueryParam("endLat") Double endLat,
            @QueryParam("endLong") Double endLong){

        if (startLat == null || startLong == null || endLat == null || endLong == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"All parameters (startX, startY, endX, endY) are required.\"}")
                    .build();
        }
        String url = String.format("%s/route/v1/driving/%s,%s;%s,%s?geometries=geojson", routeServer, startLat, startLong, endLat, endLong);
        log.info(url);
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().
                    uri(new URI(url)).
                    GET().build();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info(response.body().toString());
            //throw new Exception("ahhhh");
            return Response.ok(response.body().toString()).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(
            @QueryParam("LanSt") double LanStart,
            @QueryParam("LongSt") double LongSt,
            @QueryParam("LanDs") double LanDest,
            @QueryParam("LongSt") double LangDest
            ){
        long startTime = System.nanoTime();
        //TODO: Validate incoming json

        List<Route> routes = Route.listAll();

        log.info("");

        long endTime = System.nanoTime();

        // Calculate the duration in milliseconds
        long duration = (endTime - startTime) / 1_000_000;

        Map<String, Object> response = new HashMap<>();
        response.put("durationMillis", duration);
        response.put("routes", routes);

        return Response.ok(response).build();
    }
}
