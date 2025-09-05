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
@Table(name = "course",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_course_name_semester", columnNames = {"course_name", "semester_id"})
        },
        indexes = {
                @Index(name = "idx_course_teacher_id", columnList = "teacher_id"),
                @Index(name = "idx_course_semester_id", columnList = "semester_id")
        })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private Person teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id", nullable = false, foreignKey = @ForeignKey(name = "fk_course_semester"))
    private Semester semester;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants = new HashSet<>();

    public Course() {
    }

}
