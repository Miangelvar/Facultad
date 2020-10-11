package com.example.onetomany.controller;

import com.example.onetomany.entity.Inscription;
import com.example.onetomany.entity.Inscription;
import com.example.onetomany.service.InscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/inscriptions")
@Slf4j
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @GetMapping
    public List<Inscription> findAll() {
        return inscriptionService.findAll();
    }

    @GetMapping("/{studentId}/{courseId}")
    public Inscription findById(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        Optional<Inscription> inscription = inscriptionService.findById(studentId, courseId);
        if (!inscription.isPresent()) {
            log.error("inscription does not exist");
        }
        return inscription.get();
    }

    @PostMapping()
    public void save(@RequestBody Inscription newInscription) {
        inscriptionService.save(newInscription);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        inscriptionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Inscription updateById(@RequestBody Inscription newInscription, @PathVariable Long id) {
//        Optional<Inscription> inscription = inscriptionService.findById(id);
//
//        if (inscription.isPresent()) {
//// Pending            newInscription.setId(id);
//            inscriptionService.save(newInscription);
//            return inscription.get();
//        }

        return newInscription;
    }
}
