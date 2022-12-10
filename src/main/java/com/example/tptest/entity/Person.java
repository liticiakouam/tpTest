package com.example.tptest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String firstname;
    private String lastname;
    private String sexe;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

}
