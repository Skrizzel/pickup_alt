package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Booking")
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
    // It is not working
    @Path("/DolleFunktionPfad")
    @Produces(MediaType.TEXT_PLAIN)
    public String DolleFunktion(){
        return "Hallo";
    }

    @Path("/StandardPreisInfoText")
    @Produces(MediaType.TEXT_PLAIN)
    public String setBasePrice() {
        String StandardPreisInfoText = "Info: Der Standardpreis muss von jedem Mitfahrere gezahlt werden, unabhängig von der Kilometerpauschale.";
        String TextStandardPreis = "Bitte geben Sie einen Standard Preis ein:";
        return StandardPreisInfoText;
    }

    @Path("/PreisJeKilometerInfoText")
    @Produces(MediaType.TEXT_PLAIN)
    public String setKilometerPrice(){
        String PreisJeKilometerInfoText = "Info: Der Preis je Kilometer muss von jedem Mitfahrere für die mitgefahrene Strecke gezahlt werden.";
        String PreisJeKilometer = "Bitte geben Sie den Preis je Kilometer ein:";
        return PreisJeKilometerInfoText ;
    }
}

// Aktueller Stand
// Pfad für die Methoden nicht angezeigt
