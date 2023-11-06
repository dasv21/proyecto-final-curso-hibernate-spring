package com.santiago.proyectohibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(unique = true, length = 20, nullable = false)
    private String dni;

    @Column(unique = true, length = 30, nullable = false)
    private String email;

    private Boolean active;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // --------- Asociaciones ---------

    @JsonIgnoreProperties("user")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;

    @JsonIgnoreProperties("user")
    @OneToOne(cascade = CascadeType.ALL)
    private BillingInfo billingInfo;
}
