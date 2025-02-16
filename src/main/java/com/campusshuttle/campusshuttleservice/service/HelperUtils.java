package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.Coordinates;
import com.campusshuttle.campusshuttleservice.entity.Passenger;
import com.campusshuttle.campusshuttleservice.entity.Shuttle;
import com.campusshuttle.campusshuttleservice.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class HelperUtils {

    private static final Shuttle shuttle = Shuttle.getInstance();

    @Autowired
    private PassengerRepository passengerRepository;

    // Removes passenger from a specified queue based on SUID
    public static void discardPassengerFromQueue(Passenger passengerToBeRemoved, List<Passenger> listToBeModified) {
        listToBeModified.removeIf(passenger -> passenger.getSuid().equals(passengerToBeRemoved.getSuid()));
    }

    // Sorts passengers by ETA and wait duration
    public static List<Passenger> getPrioritizedPassengerList(List<Passenger> passengers, boolean isTravelling) {
        Coordinates shuttleCoordinates = Shuttle.getCoordinates();

        passengers.sort((p1, p2) -> {
            double eta1 = calculateETA(p1, shuttleCoordinates, isTravelling);
            double eta2 = calculateETA(p2, shuttleCoordinates, isTravelling);
            int compareETA = Double.compare(eta1, eta2);

            if (compareETA == 0) {
                return Long.compare(p2.getWaitDurationCounter(), p1.getWaitDurationCounter());
            }
            return compareETA;
        });

        return passengers;
    }

    // Calculates ETA for a passenger based on their location and shuttle location
    private static double calculateETA(Passenger passenger, Coordinates shuttleCoordinates, boolean isTravelling) {
        Coordinates targetCoordinates = isTravelling ? 
                passenger.getDropoffLocation() : passenger.getPickupLocation();

        double distance = GeoDistanceCalculator.computeDistance(targetCoordinates, shuttleCoordinates);
        return (distance / shuttle.getSpeed()) * 60;
    }
}
