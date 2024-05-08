package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    //@Query(value = "SELECT COUNT(*) FROM prescriptions p WHERE p.brand_name = ?1 AND p.location_name = ?2", nativeQuery = true)


   /* @Query(value = "SELECT l.latitude, l.longitude, COUNT(*) as count FROM prescriptions p JOIN prescription_brands pb ON p.id = pb.prescription_id JOIN brands b ON pb.brand_id = b.id JOIN locations l ON p.location_id = l.id WHERE b.id = ?1 AND l.id = ?2 GROUP BY b.brand_name, l.location_name, l.latitude, l.longitude", nativeQuery = true)*/

    @Query(value = "SELECT l.latitude, l.longitude, COUNT(*) as count FROM prescriptions p JOIN prescription_brands pb ON p.id = pb.prescription_id JOIN brands b ON pb.brand_id = b.id JOIN locations l ON p.location_id = l.id WHERE b.id = ?1 AND l.id = ?2", nativeQuery = true)
    int getBrandCount(String brandName, String locationName);
}