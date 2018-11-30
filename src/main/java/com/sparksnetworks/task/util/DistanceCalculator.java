package com.sparksnetworks.task.util;

import com.sparksnetworks.task.model.City;
import com.sparksnetworks.task.model.Profile;

/**
 * @author Maroju, Jithender on 28/11/18
 */
public class DistanceCalculator {

    public static double distance(Profile p1, Profile p2){
        City c1 = p1.getCity();
        City c2 = p2.getCity();
        if(c1 == null || c2 == null) return 0;
        return distance(c1.getLat(), c1.getLon(), c2.getLat(), c2.getLon());
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) return 0;

        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;  // since we are supporting only in km
        return (dist);

    }
}
