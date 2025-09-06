package com.teko.gradetool.service;

import com.teko.gradetool.entities.Person;
import com.teko.gradetool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPerson(Person person) {
        return personRepository.save(person);
    }

}