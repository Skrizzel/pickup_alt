package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;

@Entity
public class Booking extends PanacheEntity {
    @ManyToOne
    private Car car;
    @ManyToOne
    private AppUser driver;
    @ManyToOne
    private AppUser passenger;
    @ManyToOne
    private Route route;

    public Booking() {}


}
