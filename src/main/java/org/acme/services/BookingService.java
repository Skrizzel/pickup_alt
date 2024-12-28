package org.acme.services;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Booking;

@Path("/Booking")
public class BookingService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    // Adds a new booking to the database table
    public Response addBooking(Booking booking) {
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }
}