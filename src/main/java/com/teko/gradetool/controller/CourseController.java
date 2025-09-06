package com.teko.gradetool.controller;

import com.teko.gradetool.dto.CourseSemesterDto;
import com.teko.gradetool.entities.Course;
import com.teko.gradetool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public ResponseEntity<Course> assignTeacher(
            @PathVariable Long courseId,
            @PathVariable Long teacherId) {
        Course updated = courseService.assignTeacherToCourse(courseId, teacherId);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseSemesterDto>> allCourseSemesterInfo() {
        return ResponseEntity.ok(courseService.getAllCourseSemesterInfo());
    }

}