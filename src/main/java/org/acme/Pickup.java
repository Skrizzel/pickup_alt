package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
//
@Path("/Pickup")
class Pickup {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloHello() {
        return "Hello from Quarkus REST";
    }
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String helloPickup() {
//        return "Hello Pickup World";
    }
//    public static void main(String[] args){system.out.println("Hello World.");}
//}

