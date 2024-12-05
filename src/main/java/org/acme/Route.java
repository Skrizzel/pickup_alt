package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.prefs.Preferences;

@Entity
public class Route extends PanacheEntity {
    //private Preferences prefs; //brother ewwww whats that? ewww brother ewww
    private String routeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float distance;
    @ManyToOne
    private Address startAddress;
    @ManyToOne
    private Address endAddress;
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Car car;

    public Route() {
    }

    /*
    public Route(){
        prefs = Preferences.userNodeForPackage(Route.class);
        prefs.put("APIKey", "XXXXXXXabcde");
    }

    public String APIKey(){
        return prefs.get("APIKey", "def");
    }

     */


}