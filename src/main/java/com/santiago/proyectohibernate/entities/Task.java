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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String title;

    @Column(length = 200)
    private String description;

    private Boolean finish;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    // --------- Asociaciones ---------

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
