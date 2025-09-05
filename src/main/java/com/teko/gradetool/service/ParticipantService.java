package com.teko.gradetool.service;

import com.teko.gradetool.entities.Course;
import com.teko.gradetool.entities.Participant;
import com.teko.gradetool.entities.Person;
import com.teko.gradetool.repository.ParticipantRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final EntityManager entityManager;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, EntityManager entityManager) {
        this.participantRepository = participantRepository;
        this.entityManager = entityManager;
    }

    public Participant insertParticipant(Participant participant) {

        if (participant.getPerson() != null && participant.getPerson().getId() != null) {
            Person personRef = entityManager.getReference(Person.class, participant.getPerson().getId());
            participant.setPerson(personRef);
        }
        if (participant.getCourse() != null && participant.getCourse().getId() != null) {
            Course courseRef = entityManager.getReference(Course.class, participant.getCourse().getId());
            participant.setCourse(courseRef);
        }

        Participant saved = participantRepository.save(participant);

        return participantRepository.findWithPersonAndCourseById(saved.getId())
                .orElseThrow(() -> new IllegalStateException("Save failed"));
    }
}