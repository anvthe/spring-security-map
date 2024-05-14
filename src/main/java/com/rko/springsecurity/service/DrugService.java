package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Drug;
import com.rko.springsecurity.dto.DrugDTO;
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

    public String getDrugByName(String name) {
        Optional<Drug> drugOptional = drugRepository.findByName(name);
        return drugOptional.map(Drug::getName).orElse(null);
    }

    public Drug getDrugById(Long drugId) {
        Optional<Drug> drugOptional = drugRepository.findById(drugId);
        return drugOptional.orElse(null);
    }

    public List<DrugDTO> getAllDrugs() {
        return drugRepository.findAll()
                .stream()
                .map(drug -> new DrugDTO(drug.getName()))
                .toList();
    }
}