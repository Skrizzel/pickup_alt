package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/database")
@ApplicationScoped
public class DatabaseManager {
    @Inject
    EntityManager entityManager;

    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    @POST
    @Transactional
    public void createUser() {
        AppUser user = new AppUser("Joe", "1234", "jones@google.com", null);
        entityManager.persist(user);
    }

    public void testaddress() {
        Address address = new Address();
        entityManager.persist(address);
    }

    public void testbooking() {
        Booking booking = new Booking();
        entityManager.persist(booking);
    }public void testCar() {
        Car car = new Car();
        entityManager.persist(car);
    }public void testmessage() {
        Message message = new Message();
        entityManager.persist(message);
    }public void testraing() {
        Rating rating = new Rating();
        entityManager.persist(rating);
    }public void testroute() {
        Route route = new Route();
        entityManager.persist(route);
    }
}
