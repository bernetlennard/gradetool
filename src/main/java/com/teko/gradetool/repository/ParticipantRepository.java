package com.teko.gradetool.repository;

import com.teko.gradetool.dto.PersonSummaryDto;
import com.teko.gradetool.entities.Participant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @EntityGraph(attributePaths = {"person", "course"})
    Optional<Participant> findWithPersonAndCourseById(Long id);

    @Query("""
       select new com.teko.gradetool.dto.PersonSummaryDto(p.name, p.birthday)
       from Participant par
       join par.person p
       where par.course.id = :courseId
       """)
    List<PersonSummaryDto> findPersonsByCourseId(@Param("courseId") Long courseId);

}