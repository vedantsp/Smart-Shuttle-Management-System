package com.campusshuttle.campusshuttleservice.controller;

import com.campusshuttle.campusshuttleservice.entity.Student;
import com.campusshuttle.campusshuttleservice.service.UserRegistrationServiceImpl;
import com.campusshuttle.campusshuttleservice.errors.InvalidStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    // THIS API IS TO REGISTER A STUDENT TO THE DB
    @Autowired
    private UserRegistrationServiceImpl userRegistrationService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) throws InvalidStudentException {
        return userRegistrationService.saveToDb(student);

    }
}
