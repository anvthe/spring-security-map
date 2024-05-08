package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name")
    private String locationName;
    private double latitude;
    private double longitude;

/* @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Brand> brands;*/

   /* @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Generic> generics;*/

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    // Constructors, getters, and setters
}