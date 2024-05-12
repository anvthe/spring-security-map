package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

   /* @Autowired
    private VendorService vendorService;*/

    public String getDrugByName(String drugName) {
        Optional<Drug> drugOptional = drugRepository.findByDrugName(drugName);
        return drugOptional.map(Drug::getDrugName).orElse(null);
    }

    public Drug getDrugById(Long drugId) {
        Optional<Drug> drugOptional = drugRepository.findById(drugId);
        return drugOptional.orElse(null);
    }

    public List<Drug> getAllDrugs() {
        return (List<Drug>) drugRepository.findAll();
    }

}