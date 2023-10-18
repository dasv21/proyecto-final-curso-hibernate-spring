package com.santiago.proyectohibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String titulo;

    @Column(length = 200)
    private String descripcion;

    private Boolean finalizada;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @ManyToMany
    private ArrayList<Tag> etiquetas;
}
