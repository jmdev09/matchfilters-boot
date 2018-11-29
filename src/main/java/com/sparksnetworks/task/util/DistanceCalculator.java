package com.sparksnetworks.task.util;

/**
 * @author Maroju, Jithender on 28/11/18
 */
public class DistanceCalculator {

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) return 0;

        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;  // since we are supporting only in km
        return (dist);

    }

    public static void main(String[] args) {

        System.out.println(DistanceCalculator.distance(50.768036,0.290472,51.509865,-0.11809));
        System.out.println(DistanceCalculator.distance(50.768036,0.290472,50.768036,0.290472));
    }
}
