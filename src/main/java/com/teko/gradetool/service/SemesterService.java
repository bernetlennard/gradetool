package com.teko.gradetool.service;

import com.teko.gradetool.entities.Semester;
import com.teko.gradetool.repository.SemesterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {

    private SemesterRepository semesterRepository;

    @Autowired
    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Semester insertSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

}
