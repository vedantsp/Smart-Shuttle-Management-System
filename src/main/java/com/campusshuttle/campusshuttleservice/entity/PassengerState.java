package com.campusshuttle.campusshuttleservice.entity;

public enum PassengerState {
    PENDING,     // The passenger is waiting to be picked up
    ONBOARD,     // The passenger is in the shuttle
    DROPPED_OFF  // The passenger has been dropped off
}
