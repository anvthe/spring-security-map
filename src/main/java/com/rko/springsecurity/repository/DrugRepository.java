package com.rko.springsecurity.repository;

import com.rko.springsecurity.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
    Optional<Drug> findByName(String drugName);

    Optional<Drug> findById(Long drugId);
}
