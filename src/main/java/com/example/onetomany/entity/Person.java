package com.example.onetomany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
//import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Person {


    @Column(unique = true)
    private String identification;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private String email;

    private String phone;

}
