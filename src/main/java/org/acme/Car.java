package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Car extends PanacheEntity {
    private int seats;
    private String plate;
    private String description;
    private byte[] image;
    private float kilometerPrice;
    private float basePrice;
    @ManyToOne
    private AppUser user;

    public Car() {
    }

}
