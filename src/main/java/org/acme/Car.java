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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public float getKilometerPrice() {
        return kilometerPrice;
    }

    public void setKilometerPrice(float kilometerPrice) {
        this.kilometerPrice = kilometerPrice;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Car() {
    }

}
