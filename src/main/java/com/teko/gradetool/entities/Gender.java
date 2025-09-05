package com.teko.gradetool.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "gender",
        indexes = {
                @Index(name = "idx_person_gender_id", columnList = "id")
        })
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender", nullable = false, unique = true)
    private String gender;

    @OneToMany(mappedBy = "gender")
    private Set<Person> persons = new HashSet<>();

    public Gender() {
    }

}
