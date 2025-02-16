package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.Coordinates;
import com.campusshuttle.campusshuttleservice.entity.Passenger;
import com.campusshuttle.campusshuttleservice.entity.Shuttle;
// import com.campusshuttle.campusshuttleservice.repository.PassengerRepository;
// import com.campusshuttle.campusshuttleservice.repository.StudentRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShuttleServiceImpl implements ShuttleService {

    // @Autowired
    // private StudentRepository studentRepository;

    // @Autowired
    // private PassengerRepository passengerRepository;

    private final Shuttle shuttle = Shuttle.getInstance();

    // Picks a passenger based on priority (distance and wait time)
    @Override
    public String pickedPassenger() {
        List<Passenger> waitList = shuttle.getWaitList();
        
        if (waitList == null || waitList.isEmpty()) {
            return "No passengers waiting.";
        }

        // Get the highest priority passenger from the wait list
        List<Passenger> prioritizedPassengers = HelperUtils.getPrioritizedPassengerList(waitList, false);
        if (prioritizedPassengers.isEmpty()) {
            return "No passengers available for pickup.";
        }

        Passenger nextPassenger = prioritizedPassengers.get(0);
        shuttle.getWaitList().remove(nextPassenger);
        shuttle.getCurrentPassengers().add(nextPassenger);

        return "Picked Passenger: " + nextPassenger.getSuid();
    }

    // Drops a passenger based on priority (closest or longest waiting)
    @Override
    public String dropPassenger() {
        List<Passenger> travelList = shuttle.getCurrentPassengers();
        
        if (travelList == null || travelList.isEmpty()) {
            return "No passengers to drop off.";
        }

        // Get the highest priority passenger to drop
        List<Passenger> prioritizedPassengers = HelperUtils.getPrioritizedPassengerList(travelList, true);
        if (prioritizedPassengers.isEmpty()) {
            return "No passengers available to drop off.";
        }

        Passenger nextDropPassenger = prioritizedPassengers.get(0);
        travelList.remove(nextDropPassenger);

        return "Dropped Passenger: " + nextDropPassenger.getSuid();
    }

    // Returns current shuttle coordinates
    @Override
    public String shuttleLocation() {
        Coordinates coords = shuttle.getCoordinates();
        if (coords == null) {
            return "Coordinates are not available.";
        }

        return "Shuttle Location: Latitude: " + coords.getLatitude() + ", Longitude: " + coords.getLongitude();
    }
}
