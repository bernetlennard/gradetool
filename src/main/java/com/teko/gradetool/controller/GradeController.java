package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Grade;
import com.teko.gradetool.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/addGrade")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
        Grade saved = gradeService.insertGrade(grade);
        return ResponseEntity.ok(saved);
    }
}