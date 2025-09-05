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
@Table(name = "person",
        indexes = {
                @Index(name = "idx_person_gender_id", columnList = "gender_id")
        })
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", foreignKey = @ForeignKey(name = "fk_person_gender"))
    private Gender gender;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> taughtCourses = new HashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<Participant> participations = new HashSet<>();

    public Person() {
    }

}
