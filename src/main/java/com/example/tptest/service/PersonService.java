package com.example.tptest.service;

import com.example.tptest.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public Person createPerson(Person person);
    public List<Person> readPerson();
    public Person updatePerson(Person person);
    public void deletePerson(long id);
    public Person findByEmailAndPassword(String email, String password);
}
