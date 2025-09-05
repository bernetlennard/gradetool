package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Course;
import com.teko.gradetool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course saved = courseService.insertCourse(course);
        return ResponseEntity.ok(saved);
    }
}