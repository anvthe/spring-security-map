package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query(value = "SELECT COUNT(*) FROM Prescription p JOIN p.brands b JOIN p.location l WHERE b.id = ?1 AND l.id = ?2",
            nativeQuery = true)
    int countUsersByBrandAndLocation(String brandName, String locationName);
}