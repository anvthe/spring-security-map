package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("SELECT COUNT(p) FROM Prescription p JOIN p.drugs b JOIN p.location l WHERE b.drugName = :drugName AND l.locationName = :locationName")
    int countUsersByDrugNameAndLocationName(@Param("drugName") String drugName, @Param("locationName") String locationName);



  /*  @Query("SELECT COUNT(p) FROM Prescription p JOIN p.drugs b JOIN p.location l WHERE b.id = :drugId AND l.id = :locationId")
    int countUsersByDrugIdAndLocationId(@Param("drugId") Long drugId, @Param("locationId") Long locationId);*/

   /* @Query(value = "SELECT COUNT(p) FROM Prescription p JOIN p.brands b JOIN p.location l WHERE b.brandName = :brandName AND l.locationName = :locationName")
    int countUsersByBrandNameAndLocationName(String brandName, String locationName);*/
}