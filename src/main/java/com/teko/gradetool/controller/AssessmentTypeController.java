package com.teko.gradetool.controller;

import com.teko.gradetool.entities.AssessmentType;
import com.teko.gradetool.service.AssessmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessmentType")
public class AssessmentTypeController {
    private final AssessmentTypeService assessmentTypeService;

    @Autowired
    public AssessmentTypeController(AssessmentTypeService assessmentTypeService) {
        this.assessmentTypeService = assessmentTypeService;
    }

    @PostMapping("/addAssessmentType")
    public ResponseEntity<AssessmentType> addAssessmentType(@RequestBody AssessmentType assessmentType) {
        AssessmentType saved = assessmentTypeService.insertAssessmentType(assessmentType);
        return ResponseEntity.ok(saved);
    }
}