package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @Path("routes")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Map<String, Object> routes() {
        // Construct the ApiResponse object
        Routes rt = new Routes();
        Map<String, Object> response = new HashMap<>();

        response.put("code", 200);
        response.put("message", "Success");
        response.put("apiKey", rt.APIKey());

        return response;
    }
}
