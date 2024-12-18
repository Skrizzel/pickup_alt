package org.acme.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Address;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


@Path("/address")
public class AdressService {

    @ConfigProperty(name = "mifahrapp.backend.addressServer")
    private String addressServer;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addAddress(Address address) {
        if (address == null || address.getStreet() == null || address.getCity() == null || address.getHouseNumber() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"City, Street and HouseNumber are required fields.\"}")
                    .build();
        }
        try {
            // Build the query to the geocoding API
            String query = String.format("%s/search?q=%s&format=json&limit=1",
                    addressServer,
                    URLEncoder.encode(address.getPostalCode() + " " + address.getCity() + " " + address.getStreet() + " " + address.getHouseNumber(), StandardCharsets.UTF_8));

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(query))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());

            if (rootNode.isArray() && !rootNode.isEmpty()) {
                JsonNode firstResult = rootNode.get(0);

                address.setLatitude(firstResult.get("lat").asDouble());
                address.setLongitude(firstResult.get("lon").asDouble());
            } else {
                throw new Exception();
            }

            address.persist();

            return Response.ok(address).status(Response.Status.CREATED).build();

        } catch (Exception e) {
            //e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Failed to fetch coordinates.\"}")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAddress(@PathParam("id") Long id) {
        Address address = Address.findById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Address not found.\"}")
                    .build();
        }
        address.delete();
        return Response.ok("{\"message\": \"Address deleted successfully.\"}").build();
    }
}
