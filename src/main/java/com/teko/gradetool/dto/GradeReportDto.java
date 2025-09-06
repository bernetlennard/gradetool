package com.teko.gradetool.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GradeReportDto(
        String personName,
        String courseName,
        BigDecimal grade,
        String assessmentName,
        String assessmentType,
        LocalDate date
) {}
