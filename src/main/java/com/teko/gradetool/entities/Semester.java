package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "semester",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_semester_name", columnNames = {"semester_name"})
        })
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semester_name", nullable = false, unique = true)
    private String semesterName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Course> courses = new HashSet<>();

    public Semester() {
    }

}
