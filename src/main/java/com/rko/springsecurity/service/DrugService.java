package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

    public String getDrugByName(String drugName) {
        Optional<Drug> drugOptional = drugRepository.findByDrugName(drugName);
        return drugOptional.map(Drug::getDrugName).orElse(null);
    }

 /*   public Long getDrugById(Long drugId) {
        Optional<Drug> drugOptional = drugRepository.findByDrugId(drugId);
        return drugOptional.map(Drug::getId).orElse(null);
    }*/

}