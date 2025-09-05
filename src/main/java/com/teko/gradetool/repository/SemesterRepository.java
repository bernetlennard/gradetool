package com.teko.gradetool.repository;

import com.teko.gradetool.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

}
