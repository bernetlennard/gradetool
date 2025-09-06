package com.teko.gradetool.service;

import com.teko.gradetool.dto.PersonSummaryDto;
import com.teko.gradetool.entities.Course;
import com.teko.gradetool.entities.Participant;
import com.teko.gradetool.entities.Person;
import com.teko.gradetool.repository.ParticipantRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final EntityManager entityManager;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, EntityManager entityManager) {
        this.participantRepository = participantRepository;
        this.entityManager = entityManager;
    }

    public Participant insertParticipant(Long personId, Long courseId) {
        Participant participant = new Participant();
        Person personRef = entityManager.getReference(Person.class, personId);
        participant.setPerson(personRef);
        Course courseRef = entityManager.getReference(Course.class, courseId);
        participant.setCourse(courseRef);
        Participant saved = participantRepository.save(participant);

        return participantRepository.findWithPersonAndCourseById(saved.getId())
                .orElseThrow(() -> new IllegalStateException("Save failed"));
    }

    public List<PersonSummaryDto> getPersonsByCourse(Long courseId) {
        return participantRepository.findPersonsByCourseId(courseId);
    }

}