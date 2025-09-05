package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_person"))
    @JsonIgnoreProperties({"participations", "taughtCourses", "gender"})
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant_course"))
    @JsonIgnoreProperties({"participants", "semester", "teacher"})
    private Course course;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades = new HashSet<>();

    public Participant() {
    }

}
