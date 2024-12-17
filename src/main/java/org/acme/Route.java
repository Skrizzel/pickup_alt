package org.acme;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ManyToOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.prefs.Preferences;

@Entity
@ApplicationScoped
@Path("")
public class Route extends PanacheEntity {
    private static final Logger log = LoggerFactory.getLogger(Route.class);
    //private Preferences prefs; //brother ewwww whats that? ewww brother ewww
    private String routeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float distance;
    @ManyToOne
    private Address startAddress;
    @ManyToOne
    private Address endAddress;
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Car car;

    @ConfigProperty(name = "mifahrapp.backend.routeServer")
    private String routeServer;


    public Route() {
    }

    @Path("routesold")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response test() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().
                    uri(new URI(routeServer + "/route/v1/driving/13.388860,52.517037;13.397634,52.529407?overview=full&steps=true&geometries=geojson")).
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
            @QueryParam("startX") double startX,
            @QueryParam("startY") double startY,
            @QueryParam("endX") double endX,
            @QueryParam("endY") double endY){
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().
                    uri(new URI(String.format("%s/route/v1/driving/%s,%s;%s,%s?geometries=geojson", routeServer, startX, startY, endX, endY))).
                    GET().build();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.debug(response.body().toString());
            //throw new Exception("ahhhh");
            return Response.ok(response.body().toString()).build();
        } catch (Exception e){
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}

