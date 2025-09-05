package com.teko.gradetool.service;

import com.teko.gradetool.entities.Course;
import com.teko.gradetool.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course insertCourse(Course course) {
        return courseRepository.save(course);
    }
}