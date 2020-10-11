package com.example.onetomany.service;

import com.example.onetomany.entity.Inscription;
import com.example.onetomany.repository.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    public Optional<Inscription> findById(Long studentId, Long courseId) {
        return inscriptionRepository.findByStudentIdAndAndCourseId(studentId, courseId);
    }

    public void save(Inscription inscription) {
        inscriptionRepository.save(inscription);
    }

    public void deleteById(Long id) {
//        inscriptionRepository.deleteById(id);
    }
}
