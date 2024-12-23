package org.acme.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.JsonObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OSRMClient {
    @ConfigProperty(name = "mifahrapp.backend.routeServer")
    private String OSRM_BASE_URL;

    public double calculateDistance(double startLat, double startLon, double endLat, double endLon) throws Exception {
        String url = String.format("%s/route/v1/driving/%f,%f;%f,%f?overview=false",
                OSRM_BASE_URL, startLon, startLat, endLon, endLat);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse JSON Response
        return parseDistanceFromResponse(response.body());
    }

    private double parseDistanceFromResponse(String jsonResponse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        // Navigate to the "routes" array and get the "distance" field of the first route
        return rootNode.path("routes")
                .get(0)
                .path("distance")
                .asDouble(); // Distance in meters
    }
}
