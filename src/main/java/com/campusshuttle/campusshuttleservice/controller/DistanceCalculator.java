package com.campusshuttle.campusshuttleservice.controller;

import com.campusshuttle.campusshuttleservice.entity.Coordinates;
import com.campusshuttle.campusshuttleservice.service.GeoDistanceCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DistanceCalculator {

    // This API calculates the distance between two coordinates using the Haversine Algorithm
    @GetMapping("/distanceCalculator")
    public String calculateDistance(
            @RequestParam double latitude1,
            @RequestParam double longitude1,
            @RequestParam double latitude2,
            @RequestParam double longitude2) {

        Coordinates point1 = new Coordinates(latitude1, longitude1);
        Coordinates point2 = new Coordinates(latitude2, longitude2);

        // Use GeoDistanceCalculator to compute the distance
        return String.valueOf(GeoDistanceCalculator.computeDistance(point1, point2));
    }
}


