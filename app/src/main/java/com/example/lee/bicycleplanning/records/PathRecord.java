package com.example.lee.bicycleplanning.records;

/**
 * Created by lee on 2015-03-22.
 */
public class PathRecord {
    private double distance;
    private int elapsedTimeInMinute;
    private double rating;

    public PathRecord(double distance, int elapsedTimeInMinute, double rating) {
        this.distance = distance;
        this.elapsedTimeInMinute = elapsedTimeInMinute;
        this.rating = rating;
    }

    public double getDistance() {
        return distance;
    }

    public int getElapsedTimeInMinute() {
        return elapsedTimeInMinute;
    }

    public double getRating() {
        return rating;
    }
}
