package com.campusshuttle.campusshuttleservice.repository;

import com.campusshuttle.campusshuttleservice.entity.Passenger;
import com.campusshuttle.campusshuttleservice.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByEstimatedArrivalTimeLessThan(double estimatedArrivalTime);
    List<Passenger> findByDropoffLocation(Coordinates dropoffLocation);
}
