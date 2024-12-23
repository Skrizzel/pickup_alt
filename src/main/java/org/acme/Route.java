package org.acme;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Route extends PanacheEntity {
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getLatstart() {
        return latstart;
    }

    public void setLatstart(Double latstart) {
        this.latstart = latstart;
    }

    public Double getLongstart() {
        return longstart;
    }

    public void setLongstart(Double longstart) {
        this.longstart = longstart;
    }

    public Double getLatdest() {
        return latdest;
    }

    public void setLatdest(Double latdest) {
        this.latdest = latdest;
    }

    public Double getLongdest() {
        return longdest;
    }

    public void setLongdest(Double longdest) {
        this.longdest = longdest;
    }

    private String routeName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float distance;
    private Double latstart;
    private Double longstart;
    private Double latdest;
    private Double longdest;

    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Car car;

    public Route() {
    }
}

