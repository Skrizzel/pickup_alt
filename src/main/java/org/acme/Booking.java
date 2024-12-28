package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Booking extends PanacheEntity {
    // Database attributes
    // id attribute field should be automatically created
    @ManyToOne
    @JoinColumn(name = "idUser")
    // Foreign key from AppUser
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "idRoute")
    // Foreign key from Route
    private Route route;

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AppUser getUser() {
        return user;
    }
}