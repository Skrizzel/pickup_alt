package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Scanner;

//
@Path("/Pickup")
class Pickup {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloHello() {
        String text = "Hello quarkusDev World";
        return text;
    }
}


