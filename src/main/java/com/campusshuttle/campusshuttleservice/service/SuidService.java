package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.Student;
import com.campusshuttle.campusshuttleservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuidService {

    @Autowired
    private StudentRepository studentRep;

    // Default Constructor
    public SuidService() {
    }

    // Method to check if a student exists by SUID
    public boolean findBySUID(long suid) {
        return studentRep.existsBySuid(suid); // Ensure method name matches the repository
    }

    // Method to retrieve a student object by SUID
    public Student getStudent(long suid) {
        Optional<Student> studentOptional = studentRep.findBySuid(suid);

        // Return the student if found, otherwise throw an exception or handle the absence appropriately
        return studentOptional.orElseThrow(() -> 
            new IllegalArgumentException("Student with SUID " + suid + " not found"));
    }
}
