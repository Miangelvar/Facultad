package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@Setter
//@Getter
public class Faculty{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
//    @JsonManagedReference
    @OneToMany(mappedBy = "faculty")
    private List<Career> careers;

    @OneToOne
    private Dean dean;
}
