package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.Coordinates;
import com.campusshuttle.campusshuttleservice.entity.Student;
import com.campusshuttle.campusshuttleservice.entity.UserStatus;
import com.campusshuttle.campusshuttleservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SuidService suidService;

    @Autowired
    private ETACalculator etaCalculator;

    @Autowired
    private GeocodingService geocodingService;

    // Method to save the student object to the database
    @Override
    public Student saveToDb(Student student) {
        return studentRepository.save(student);
    }

    // Request pickup for a student
    @Override
    public String requestPickup(long suid, String pickupAddress, String dropAddress) throws ServiceUnavailableException {

        // Check if the student with the provided SUID exists in the database
        if (!suidService.findBySUID(suid)) {
            throw new ServiceUnavailableException("SUID INCORRECT");
        }

        // Retrieve the Student object from the database
        Student student = suidService.getStudent(suid);

        // Check the student's current status and throw appropriate exceptions if they are already waiting or picked up
        if (student.getUserStatus() == UserStatus.WAITING) {
            throw new ServiceUnavailableException("You're already on the waitlist.");
        }
        if (student.getUserStatus() == UserStatus.PICKEDUP) {
            throw new ServiceUnavailableException("You can't request while on a ride.");
        }

        // Use the geocoding service to convert addresses into geographical coordinates
        Map<String, Double> pickupCoordinatesMap = geocodingService.getCoordinates(pickupAddress);
        Map<String, Double> dropCoordinatesMap = geocodingService.getCoordinates(dropAddress);

        if (pickupCoordinatesMap == null || dropCoordinatesMap == null || 
            !pickupCoordinatesMap.containsKey("lat") || !pickupCoordinatesMap.containsKey("lng") || 
            !dropCoordinatesMap.containsKey("lat") || !dropCoordinatesMap.containsKey("lng")) {
            throw new ServiceUnavailableException("Invalid address coordinates. Please check the addresses provided.");
        }

        Coordinates pickupCoordinates = new Coordinates(
                pickupCoordinatesMap.get("lat"),
                pickupCoordinatesMap.get("lng")
        );

        Coordinates dropCoordinates = new Coordinates(
                dropCoordinatesMap.get("lat"),
                dropCoordinatesMap.get("lng")
        );

        // Calculate the estimated time for the pickup request
        return calculateEstimatedTimeForRequest(suid, student, pickupCoordinates, dropCoordinates);
    }

    // A helper method to calculate the estimated time for a student's pickup request
    private String calculateEstimatedTimeForRequest(long suid, Student student, Coordinates pickupCoordinates, Coordinates dropCoordinates) {

        // Calculate ETA using the etaCalculator object
        String eta = etaCalculator.etaCalculation(suid, pickupCoordinates, dropCoordinates);

        // If the ETA calculation returns an empty string, we assume the service is unavailable
        if (eta == null || eta.isEmpty()) {
            return "Shuttle Service is unavailable from your location.";
        }

        // Set the student's status to WAITING, indicating they are now on the waitlist for a pickup
        student.setUserStatus(UserStatus.WAITING);
        saveToDb(student);

        return "Estimated Wait Time is " + eta + " Minutes";
    }
}
