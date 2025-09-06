package com.teko.gradetool.dto;

import java.time.LocalDate;

public record CourseSemesterDto(
        String courseName,
        String semesterName,
        LocalDate startDate,
        LocalDate endDate
) {}
