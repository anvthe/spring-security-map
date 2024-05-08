package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    @NotBlank
    private String brandName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "generic_id")
    private Generic generic;

    /*@ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;*/

    // Constructors, getters, and setters
}
