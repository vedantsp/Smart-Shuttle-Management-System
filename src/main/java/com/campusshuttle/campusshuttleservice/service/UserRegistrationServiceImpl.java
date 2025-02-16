package com.campusshuttle.campusshuttleservice.service;

import com.campusshuttle.campusshuttleservice.entity.Student;
import com.campusshuttle.campusshuttleservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.campusshuttle.campusshuttleservice.errors.InvalidStudentException;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveToDb(Student student) throws InvalidStudentException {
        // Validate SUID length and null check
        if (student.getSuid() == null || String.valueOf(student.getSuid()).length() != 9) {
            throw new InvalidStudentException("Invalid SUID. It must be a 9-digit number.");
        }

        // Check if the student already exists in the database
        if (studentRepository.existsBySuid(student.getSuid())) {
            throw new InvalidStudentException("Student SUID already exists.");
        }

        // Validate student name and email are not null or empty
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new InvalidStudentException("Invalid student name. Name cannot be null or empty.");
        }

        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new InvalidStudentException("Invalid email. Email cannot be null or empty.");
        }

        // Save the student to the repository
        return studentRepository.save(student);
    }
}
