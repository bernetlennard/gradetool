package com.teko.gradetool.repository;

import com.teko.gradetool.entities.Participant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @EntityGraph(attributePaths = {"person", "course"})
    Optional<Participant> findWithPersonAndCourseById(Long id);

}