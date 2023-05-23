package com.example.AnotherTest.Model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Characters {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String bio;

    private String gameIntroduced;

    private Integer yearIntroduced;

    private Boolean main;

    private String charType;

}
