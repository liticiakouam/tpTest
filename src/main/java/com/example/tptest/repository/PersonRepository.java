package com.example.tptest.repository;

import com.example.tptest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findByEmailAndPassword(String email, String password);
}
