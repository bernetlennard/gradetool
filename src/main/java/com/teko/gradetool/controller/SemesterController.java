package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Semester;
import com.teko.gradetool.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semester")
public class SemesterController {

    private final SemesterService semesterService;

    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/addSemester")
    public ResponseEntity<Semester> addGrade(@RequestBody Semester semester) {
        Semester savedSemester = semesterService.insertSemester(semester);
        return ResponseEntity.ok(savedSemester);
    }

}
