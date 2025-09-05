package com.teko.gradetool.service;

import com.teko.gradetool.entities.Gender;
import com.teko.gradetool.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    private final GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public Gender insertGender(Gender gender) {
        return genderRepository.save(gender);
    }
}