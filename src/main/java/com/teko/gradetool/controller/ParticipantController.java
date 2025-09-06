package com.teko.gradetool.controller;

import com.teko.gradetool.dto.PersonSummaryDto;
import com.teko.gradetool.entities.Participant;
import com.teko.gradetool.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public record ParticipantCreateRequest(Long personId, Long courseId) {}

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/addParticipant")
    public ResponseEntity<Participant> addParticipant(@RequestBody ParticipantCreateRequest participantCreateRequest) {
        Participant saved = participantService.insertParticipant(participantCreateRequest.personId(), participantCreateRequest.courseId());
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/participantlist/{courseId}")
    public ResponseEntity<List<PersonSummaryDto>> getByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(participantService.getPersonsByCourse(courseId));
    }

}