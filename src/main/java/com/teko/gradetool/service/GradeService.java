package com.teko.gradetool.service;

import com.teko.gradetool.dto.GradeReportDto;
import com.teko.gradetool.entities.Grade;
import com.teko.gradetool.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade insertGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<GradeReportDto> getGradesByCourse(Long courseId) {
        return gradeRepository.findGradesByCourseId(courseId);
    }

    public List<GradeReportDto> getGradesByPerson(Long personId) {
        return gradeRepository.findGradesByPersonId(personId);
    }

}