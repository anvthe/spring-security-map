package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("SELECT COUNT(p) FROM Prescription p JOIN p.drugs d JOIN p.location l WHERE d.drugName = :drugName AND l.locationName = :locationName")
    int countUsersByDrugNameAndLocationName(@Param("drugName") String drugName, @Param("locationName") String locationName);



    @Query("SELECT COUNT(p) FROM Prescription p JOIN p.drugs d JOIN p.location l WHERE d.id = :drugId AND l.id = :locationId")
    int countUsersByDrugIdAndLocationId(@Param("drugId") Long drugId, @Param("locationId") Long locationId);

  /*  @Query("SELECT COUNT(p) FROM Prescription p WHERE p.id = :drugId AND p.location.id = :locationId")
    List<Prescription> findByDrugIdAndLocationId(@Param("drugId") Long drugId, @Param("locationId") Long locationId);*/

    //List<Prescription> findByDrugIdAndLocationId(Long drugId, Long locationId);


   /* @Query(value = "SELECT COUNT(p) FROM Prescription p JOIN p.brands b JOIN p.location l WHERE b.brandName = :brandName AND l.locationName = :locationName")
    int countUsersByBrandNameAndLocationName(String brandName, String locationName);*/
}