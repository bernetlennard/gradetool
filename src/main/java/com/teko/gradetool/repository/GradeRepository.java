package com.teko.gradetool.repository;

import com.teko.gradetool.dto.GradeReportDto;
import com.teko.gradetool.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("""
        select new com.teko.gradetool.dto.GradeReportDto(
            per.name,
            c.courseName,
            g.grade,
            g.assessmentName,
            at.type,
            g.date
        )
        from Grade g
        join g.participant par
        join par.course c
        join par.person per
        left join g.assessmentType at
        where c.id = :courseId
        """)
    List<GradeReportDto> findGradesByCourseId(@Param("courseId") Long courseId);

    @Query("""
        select new com.teko.gradetool.dto.GradeReportDto(
            per.name,
            c.courseName,
            g.grade,
            g.assessmentName,
            at.type,
            g.date
        )
        from Grade g
        join g.participant par
        join par.course c
        join par.person per
        left join g.assessmentType at
        where per.id = :personId
        """)
    List<GradeReportDto> findGradesByPersonId(@Param("personId") Long personId);

}