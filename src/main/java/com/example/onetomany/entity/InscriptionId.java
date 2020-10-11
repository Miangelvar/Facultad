package com.example.onetomany.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class InscriptionId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentId;
    private Long courseId;
}
