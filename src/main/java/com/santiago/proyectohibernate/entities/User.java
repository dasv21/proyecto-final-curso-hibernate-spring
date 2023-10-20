package com.santiago.proyectohibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    String firstName;

    @Column(name = "last_name", length = 30)
    String lastName;

    @Column(unique = true, length = 20, nullable = false)
    String dni;

    Boolean active;

    @Column(name = "birth_date")
    LocalDate birthDate;

    // --------- Asociaciones ---------

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToOne(cascade = CascadeType.ALL)
    private BillingInfo billingInfo;

}
