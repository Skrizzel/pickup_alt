package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating extends PanacheEntity {
    private float rating;
    private String reviewText;
    @ManyToOne
    private AppUser reviewer;
    @ManyToOne
    private AppUser reviewee;


    public Rating() {}

}
