package com.sparksnetworks.task.model;

import java.io.Serializable;

/**
 * @author Maroju, Jithender on 27/11/18
 */
public class City implements Serializable {

    private String name;

    private double lat;

    private double lon;

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
