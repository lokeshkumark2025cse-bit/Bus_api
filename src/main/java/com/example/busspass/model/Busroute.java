package com.example.busspass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Busroute {
    @Id 
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long routeId;
    private Long routename;
    private String source;
    private String destination;

    public Busroute(Long routeId, Long routename, String source, String destination) {
        this.routeId = routeId;
        this.routename = routename;
        this.source = source;
        this.destination = destination;
    }
    
    public Long getRouteId() {
        return routeId;
    }
    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    public Long getRoutename() {
        return routename;
    }
    public void setRoutename(Long routename) {
        this.routename = routename;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }




}
