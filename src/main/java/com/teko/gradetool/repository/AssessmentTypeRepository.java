package com.teko.gradetool.repository;

import com.teko.gradetool.entities.AssessmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentTypeRepository extends JpaRepository<AssessmentType, Long> {
}