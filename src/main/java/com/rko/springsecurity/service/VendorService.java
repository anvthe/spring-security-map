package com.rko.springsecurity.service;

import com.rko.springsecurity.domain.Vendor;
import com.rko.springsecurity.repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        if (vendor != null) {
            vendor.getDrugs().size();
        }
        return vendor;
    }
}
