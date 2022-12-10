package com.example.tptest.controller;

import com.example.tptest.entity.Person;
import com.example.tptest.exception.InformationNotFoundException;
import com.example.tptest.exception.PersonNotFoundException;
import com.example.tptest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/person") //http://localhost:8080/person
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
            Person personSaved = personService.createPerson(person);
            if (personSaved == null) {
                throw new PersonNotFoundException("person already exist with email " + person.getEmail() + " or with password " + person.getPassword());
            }
            return ResponseEntity.ok(personSaved);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.readPerson();
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        if(updatePerson == null) {
            throw new PersonNotFoundException("person not exist with id " + person.getId());
        }

        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping(value = "/{id}") //http://localhost:8080/person/id
    public void delete(@PathVariable long id) {
        personService.deletePerson(id);
    }

    @GetMapping(value = "/{email}/{password}") //http://localhost:8080/person/email/password
    public Person findByEmailPassword(@PathVariable String email, @PathVariable String password) {
        Person personByEmailAndPassword = personService.findByEmailAndPassword(email, password);
        if (personByEmailAndPassword == null) {
            throw new InformationNotFoundException("verify your email or password ");
        }
        return personByEmailAndPassword;
    }
}
