package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "grade",
        indexes = {
                @Index(name = "idx_grade_participant_id", columnList = "participant_id"),
                @Index(name = "idx_grade_assessmenttype_id", columnList = "assessmenttype_id")
        })
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_grade_participant"))
    private Participant participant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessmenttype_id", foreignKey = @ForeignKey(name = "fk_grade_assessmenttype"))
    private AssessmentType assessmentType;

    @Column(name = "grade", nullable = false, precision = 2, scale = 1)
    private BigDecimal grade;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "assessment_name")
    private String assessmentName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Grade() {
    }
}
