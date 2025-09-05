package com.teko.gradetool.service;

import com.teko.gradetool.entities.AssessmentType;
import com.teko.gradetool.repository.AssessmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentTypeService {
    private final AssessmentTypeRepository assessmentTypeRepository;

    @Autowired
    public AssessmentTypeService(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public AssessmentType insertAssessmentType(AssessmentType assessmentType) {
        return assessmentTypeRepository.save(assessmentType);
    }
}