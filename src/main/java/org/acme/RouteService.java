package org.acme;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@ApplicationScoped
@Path("/route")
public class RouteService {
    private static final Logger log = LoggerFactory.getLogger(Route.class);

    @ConfigProperty(name = "mifahrapp.backend.routeServer")
    private String routeServer;


    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRoute(JsonNode json) {
        try {
            // Parse and validate inputs
            String routeName = json.path("routeName").asText(null);
            if (routeName == null || routeName.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"routeName is required\"}")
                        .build();
            }

            float distance = (float) json.path("distance").asDouble(0);
            String startTimeString = json.path("startTime").asText(null);
            String endTimeString = json.path("endTime").asText(null);

            LocalDateTime startTime = startTimeString != null ? LocalDateTime.parse(startTimeString) : null;
            LocalDateTime endTime = endTimeString != null ? LocalDateTime.parse(endTimeString) : null;

            // Create and populate Route object
            Route newRoute = new Route();
            newRoute.setRouteName(routeName);
            newRoute.setDistance(distance);
            newRoute.setStartTime(startTime);
            newRoute.setEndTime(endTime);

            // Assuming Address, AppUser, and Car objects are linked by their IDs
            Long startAddressId = json.path("startAddressId").asLong(0);
            Long endAddressId = json.path("endAddressId").asLong(0);
            Long userId = json.path("userId").asLong(0);
            Long carId = json.path("carId").asLong(0);

            Address startAddress = Address.findById(startAddressId);
            Address endAddress = Address.findById(endAddressId);
            AppUser user = AppUser.findById(userId);
            Car car = Car.findById(carId);

            if (newRoute.getStartAddress() == null || newRoute.getEndAddress() == null || newRoute.getUser() == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Invalid IDs for startAddress, endAddress, or user.\"}")
                        .build();
            }

            // Persist the new route
            newRoute.persist();

            log.info("Route created successfully: {}", newRoute.getRouteName());
            return Response.ok(newRoute).build();
        } catch (Exception e) {
            log.error("Error creating route", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Failed to create route\"}")
                    .build();
        }
    }

    @Path("routesold")
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
            @QueryParam("startX") Double startX,
            @QueryParam("startY") Double startY,
            @QueryParam("endX") Double endX,
            @QueryParam("endY") Double endY){

        if (startX == null || startY == null || endX == null || endY == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"All parameters (startX, startY, endX, endY) are required.\"}")
                    .build();
        }
        String url = String.format("%s/route/v1/driving/%s,%s;%s,%s?geometries=geojson", routeServer, startX, startY, endX, endY);
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
}
