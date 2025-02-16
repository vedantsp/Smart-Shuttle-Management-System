package com.campusshuttle.campusshuttleservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Embedded;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shuttle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double speed;

    @Embedded
    private Coordinates coordinates;

    @OneToMany
    private List<Passenger> waitList = new ArrayList<>();

    @OneToMany
    private List<Passenger> currentPassengers = new ArrayList<>();

    // Static variable to hold the single instance of Shuttle
    private static Shuttle instance;

    // Private constructor to prevent instantiation
    private Shuttle() {
        this.coordinates = new Coordinates(0.0, 0.0);
    }

    // Static method to return the single instance of Shuttle
    public static Shuttle getInstance() {
        if (instance == null) {
            synchronized (Shuttle.class) {
                if (instance == null) {
                    instance = new Shuttle();
                }
            }
        }
        return instance;
    }

    // Getter for coordinates
    public Coordinates getCoordinates() {
        return coordinates;
    }

    // Setter for coordinates
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    // Getter for waitList
    public List<Passenger> getWaitList() {
        return waitList;
    }

    // Setter for waitList
    public void setWaitList(List<Passenger> waitList) {
        this.waitList = waitList;
    }

    // Getter for currentPassengers
    public List<Passenger> getCurrentPassengers() {
        return currentPassengers;
    }

    // Setter for currentPassengers
    public void setCurrentPassengers(List<Passenger> currentPassengers) {
        this.currentPassengers = currentPassengers;
    }

    // Getter and setter for speed
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
