package org.acme;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Route extends PanacheEntity {
    private String routeName;
    private LocalDateTime startTime;

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

    public Address getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(Address startAddress) {
        this.startAddress = startAddress;
    }

    public Address getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(Address endAddress) {
        this.endAddress = endAddress;
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

    public Double getLong_Start() {
        return Long_Start;
    }

    public void setLong_Start(Double long_Start) {
        Long_Start = long_Start;
    }

    public Double getLat_Start() {
        return Lat_Start;
    }

    public void setLat_Start(Double lat_Start) {
        Lat_Start = lat_Start;
    }

    public Double getLong_Dest() {
        return Long_Dest;
    }

    public void setLong_Dest(Double long_Dest) {
        Long_Dest = long_Dest;
    }

    public Double getLat_Dest() {
        return Lat_Dest;
    }

    public void setLat_Dest(Double lat_Dest) {
        Lat_Dest = lat_Dest;
    }

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
    private Double Long_Start;
    private Double Lat_Start;
    private Double Long_Dest;
    private Double Lat_Dest;



    public Route() {
    }
}

