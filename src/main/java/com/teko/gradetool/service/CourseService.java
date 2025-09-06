package com.teko.gradetool.service;

import com.teko.gradetool.dto.CourseSemesterDto;
import com.teko.gradetool.entities.Course;
import com.teko.gradetool.entities.Person;
import com.teko.gradetool.repository.CourseRepository;
import com.teko.gradetool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final PersonRepository personRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, PersonRepository personRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
    }

    public Course insertCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Person teacher = personRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    public List<CourseSemesterDto> getAllCourseSemesterInfo() {
        return courseRepository.findAllWithSemester();
    }

}