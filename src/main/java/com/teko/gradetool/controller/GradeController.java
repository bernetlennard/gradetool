package com.teko.gradetool.controller;

import com.teko.gradetool.dto.GradeReportDto;
import com.teko.gradetool.entities.Grade;
import com.teko.gradetool.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<GradeReportDto>> getGradesOfCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(gradeService.getGradesByCourse(courseId));
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<GradeReportDto>> getGradesOfPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(gradeService.getGradesByPerson(personId));
    }

}