package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Prescription;
import com.rko.springsecurity.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public int countUsersByDrugNameAndLocationName(String drugName, String locationName) {
        return prescriptionRepository.countUsersByDrugNameAndLocationName(drugName, locationName);
    }

    public int countUsersByDrugIdAndLocationId(Long drugId, Long locationId) {
        return prescriptionRepository.countUsersByDrugIdAndLocationId(drugId, locationId);
    }

   /* public List<Prescription> findByDrugIdAndLocationId(Long drugId, Long locationId) {
        return prescriptionRepository.findByDrugIdAndLocationId(drugId, locationId);
    }*/
}
