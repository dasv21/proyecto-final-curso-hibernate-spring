package com.santiago.proyectohibernate.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(length = 30)
    String nombre;

    @Column(length = 30)
    String apellido;

    @Column(unique = true, length = 12, nullable = false)
    String dni;

    Boolean activo;

    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;

    // --------- Asociaciones ---------

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tareas;

    @OneToOne(cascade = CascadeType.ALL)
    private BillingInfo billingInfo;

}
