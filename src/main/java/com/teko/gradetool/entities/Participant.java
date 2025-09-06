package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "participant",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_participant_person_course", columnNames = {"person_id", "course_id"})
        },
        indexes = {
                @Index(name = "idx_participant_person_id", columnList = "person_id"),
                @Index(name = "idx_participant_course_id", columnList = "course_id")
        })
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("person-participants")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_person"))
    private Person person;

    @JsonBackReference("course-participants")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_course"))
    private Course course;

    @JsonManagedReference("participant-grades")
    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades = new HashSet<>();

    public Participant() {
    }

}
