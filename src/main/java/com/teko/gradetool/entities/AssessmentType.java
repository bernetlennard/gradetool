package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "assessmenttype")
public class AssessmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, unique = true)
    private String type;

    @JsonManagedReference("assessmenttype-grades")
    @OneToMany(mappedBy = "assessmentType")
    private Set<Grade> grades = new HashSet<>();

    public AssessmentType() {
    }

}
