package com.example.tptest.service;

import com.example.tptest.entity.Person;
import com.example.tptest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        Person personInfo = findByEmailAndPassword(person.getEmail(), person.getPassword());
        if (personInfo != null) {
            return null;
        }
        return personRepository.save(person);
    }

    @Override
    public List<Person> readPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> optionalPerson = personRepository.findById(person.getId());

        if (optionalPerson.isEmpty()) {
            return null;
        }
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findByEmailAndPassword(String email, String password) {
        return personRepository.findByEmailAndPassword(email, password);
    }

}
