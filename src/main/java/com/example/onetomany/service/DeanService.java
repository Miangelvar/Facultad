package com.example.onetomany.service;

import com.example.onetomany.entity.Dean;
import com.example.onetomany.repository.DeanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeanService {

    private final DeanRepository deanRepository;

    public List<Dean> findAll() {
        return deanRepository.findAll();
    }

    public Optional<Dean> findById(Long id) {
        return deanRepository.findById(id);
    }

    public void save(Dean dean) {
        deanRepository.save(dean);
    }

    public void deleteById(Long id) {
        deanRepository.deleteById(id);
    }
}
