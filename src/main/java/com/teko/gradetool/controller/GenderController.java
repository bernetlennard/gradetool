package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Gender;
import com.teko.gradetool.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gender")
public class GenderController {
    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @PostMapping("/addGender")
    public ResponseEntity<Gender> addGender(@RequestBody Gender gender) {
        Gender saved = genderService.insertGender(gender);
        return ResponseEntity.ok(saved);
    }
}