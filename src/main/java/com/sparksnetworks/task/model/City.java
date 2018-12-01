package com.sparksnetworks.task.model;

import java.io.Serializable;

/**
 * @author Maroju, Jithender on 27/11/18
 */
public class City implements Serializable {

    private static final long serialVersionUID = 2253361830796117815L;

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

    public City() {}

    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
