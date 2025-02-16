package com.campusshuttle.campusshuttleservice.repository;

import com.campusshuttle.campusshuttleservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Method to check if a student exists by SUID
    boolean existsBySuid(long suid); // Changed Long to long for better performance

    // Method to retrieve a student by SUID, wrapped in Optional for better null handling
    Optional<Student> findBySuid(long suid); // Changed return type to Optional<Student>
}
