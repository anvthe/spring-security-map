package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    @Query("SELECT DISTINCT v FROM Vendor v LEFT JOIN FETCH v.drugs")
    List<Vendor> findAllWithDrugs();
}
