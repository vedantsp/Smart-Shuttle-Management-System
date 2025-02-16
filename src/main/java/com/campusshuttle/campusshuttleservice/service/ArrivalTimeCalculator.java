package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.*;
import com.campusshuttle.campusshuttleservice.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrivalTimeCalculator {

    @Autowired
    private GeoDistanceCalculator GeoDistanceCalculator;

    @Autowired
    // private PassengerRepository passengerRepository;

    private final Shuttle shuttle = Shuttle.getInstance(); // Use the singleton instance of Shuttle
 

    // Estimates arrival time based on distance and shuttle speed
    public String estimateArrivalTime(long suid, Coordinates pickupLocation, Coordinates dropoffLocation) {
        // Calculate distance from shuttle to pickup location using GeoDistanceCalculator
        double distance = GeoDistanceCalculator.computeDistance(pickupLocation, shuttle.getCoordinates());

        // Get the shuttle speed
        double speed = shuttle.getSpeed();
        double estimatedArrivalTime = (distance / speed) * 60;

        if (estimatedArrivalTime > 40) {
            return ""; // Return empty string if ETA is too long
        }

        // Create a new passenger and add them to the wait list
        Passenger passenger = new Passenger.PassengerBuilder()
                .setPickupLocation(pickupLocation)
                .setDropoffLocation(dropoffLocation)
                .setEstimatedArrivalTime(estimatedArrivalTime)
                .build();

        // Use getWaitList() to add the passenger to the shuttle's wait list
        shuttle.getWaitList().add(passenger);

        return "Estimated wait time: " + estimatedArrivalTime + " minutes.";
    }
}
