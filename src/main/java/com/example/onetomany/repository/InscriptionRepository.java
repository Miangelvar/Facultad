package com.example.onetomany.repository;

import com.example.onetomany.entity.Inscription;
import com.example.onetomany.entity.InscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionId> {
    public Optional<Inscription> findByStudentIdAndAndCourseId(Long studentId, Long courseId);
}
