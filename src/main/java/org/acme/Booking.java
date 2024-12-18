// Current Task:
// fill attributes into empty tables
// create Get and Set Methods vor database attributes

package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Booking")
// Problem? The following annotation?
@Entity
public class Booking extends PanacheEntity {
    private static final Logger log = LoggerFactory.getLogger(Booking.class);
    // Is the next line necessary?
    // private static final Logger log = LoggerFactory.getLogger(BookingBooking.class);

    // Creating database
    private String basePrice;
    private String kilometerPrice;

    // Constructor
    public Booking() {}

    // Test function for creating a Path
    @Path("/DolleFunktionPfad")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String DolleFunktion(){
        return "Hallo";
    }

    @Path("/StandardPreisInfoText")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setBasePrice() {
        String StandardPreisInfoText = "Info: Der Standardpreis muss von jedem Mitfahrere gezahlt werden, unabhängig von der Kilometerpauschale.";
        String TextStandardPreis = "Bitte geben Sie einen Standard Preis ein:";
        return StandardPreisInfoText;
    }

    @Path("/PreisJeKilometerInfoText")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setKilometerPrice(){
        String PreisJeKilometerInfoText = "Info: Der Preis je Kilometer muss von jedem Mitfahrere für die mitgefahrene Strecke gezahlt werden.";
        String PreisJeKilometer = "Bitte geben Sie den Preis je Kilometer ein:";
        return PreisJeKilometerInfoText ;
    }
}