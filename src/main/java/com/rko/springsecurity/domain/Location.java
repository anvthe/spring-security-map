package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Drug> drugs;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Generic> generics;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    // Constructors, getters, and setters
}