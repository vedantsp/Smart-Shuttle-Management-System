package com.campusshuttle.campusshuttleservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println(name + " received shuttle update: " + status);
    }
}
