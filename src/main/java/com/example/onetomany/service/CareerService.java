package com.example.onetomany.service;

import com.example.onetomany.entity.Career;
import com.example.onetomany.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public List<Career> findAll() {
        return careerRepository.findAll();
    }

    public Optional<Career> findById(Long id) {
        return careerRepository.findById(id);
    }

    public void save(Career career) {
        careerRepository.save(career);
    }

    public void deleteById(Long id) {
        careerRepository.deleteById(id);
    }
}
