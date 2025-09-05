package com.teko.gradetool.controller;

import com.teko.gradetool.entities.Person;
import com.teko.gradetool.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person saved = personService.insertPerson(person);
        return ResponseEntity.ok(saved);
    }
}