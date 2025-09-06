package com.teko.gradetool.repository;

import com.teko.gradetool.dto.CourseSemesterDto;
import com.teko.gradetool.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("""
        select new com.teko.gradetool.dto.CourseSemesterDto(
            c.courseName,
            s.semesterName,
            c.startDate,
            c.endDate
        )
        from Course c
        join c.semester s
        """)
    List<CourseSemesterDto> findAllWithSemester();

}