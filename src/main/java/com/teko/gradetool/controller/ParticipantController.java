package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Participant;
import com.teko.gradetool.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/addParticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant) {
        Participant saved = participantService.insertParticipant(participant);
        return ResponseEntity.ok(saved);
    }
}