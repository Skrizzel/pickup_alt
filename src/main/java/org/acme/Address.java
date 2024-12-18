package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.persistence.Entity;

/*
 -- Example Body for Post --
 post http://server:8080/address
{
    "street": "Meisenstraße",
    "city": "Rotenburg",
    "postalCode": "36199",
    "country": "GER",
    "houseNumber": "3"
}
 */


@Entity
public class Address extends PanacheEntity {
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String houseNumber;
    private Double longitude;
    private Double latitude;


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Address() {}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}
