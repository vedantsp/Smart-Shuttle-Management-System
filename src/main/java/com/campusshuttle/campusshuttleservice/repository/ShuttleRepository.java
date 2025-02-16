package com.campusshuttle.campusshuttleservice.repository;

import com.campusshuttle.campusshuttleservice.entity.Shuttle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShuttleRepository extends JpaRepository<Shuttle, Long> {
    // Example query methods
    Shuttle findById(long id);
}
