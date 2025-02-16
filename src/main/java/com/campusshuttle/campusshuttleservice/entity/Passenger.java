package com.campusshuttle.campusshuttleservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Embedded;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.io.Serializable;

@Entity
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PassengerState state;

    @Embedded
    private Coordinates pickupLocation;

    @Embedded
    private Coordinates dropoffLocation;

    private double estimatedArrivalTime;
    private long waitDurationCounter;

    // Default constructor initializes the passenger's state to PENDING
    public Passenger() {
        this.state = PassengerState.PENDING;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PassengerState getState() {
        return state;
    }

    public void setState(PassengerState state) {
        this.state = state;
    }

    public Coordinates getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Coordinates pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Coordinates getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Coordinates dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public double getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(double estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public long getWaitDurationCounter() {
        return waitDurationCounter;
    }

    public void setWaitDurationCounter(long waitDurationCounter) {
        this.waitDurationCounter = waitDurationCounter;
    }

    // Builder pattern for creating Passenger objects
    public static class PassengerBuilder {
        private Coordinates pickupLocation;
        private Coordinates dropoffLocation;
        private double estimatedArrivalTime;

        public PassengerBuilder setPickupLocation(Coordinates pickupLocation) {
            this.pickupLocation = pickupLocation;
            return this;
        }

        public PassengerBuilder setDropoffLocation(Coordinates dropoffLocation) {
            this.dropoffLocation = dropoffLocation;
            return this;
        }

        public PassengerBuilder setEstimatedArrivalTime(double estimatedArrivalTime) {
            this.estimatedArrivalTime = estimatedArrivalTime;
            return this;
        }

        public Passenger build() {
            Passenger passenger = new Passenger();
            passenger.pickupLocation = this.pickupLocation;
            passenger.dropoffLocation = this.dropoffLocation;
            passenger.estimatedArrivalTime = this.estimatedArrivalTime;
            return passenger;
        }
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", state=" + state +
                ", pickupLocation=" + pickupLocation +
                ", dropoffLocation=" + dropoffLocation +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", waitDurationCounter=" + waitDurationCounter +
                '}';
    }
}
