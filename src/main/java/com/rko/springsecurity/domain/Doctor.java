package com.rko.springsecurity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @Column(name = "doctor_bmdc", unique = true)
    @NotBlank(message = "BMDC no is mandatory")
    private String bmdcNo;

   /* @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;*/

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;

    // Constructors, getters, and setters
}