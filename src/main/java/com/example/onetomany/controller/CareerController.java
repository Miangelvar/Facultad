package com.example.onetomany.controller;

import com.example.onetomany.entity.Career;
import com.example.onetomany.entity.Career;
import com.example.onetomany.service.CareerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/careers")
@Slf4j
public class CareerController {

    private final CareerService careerService;

    @GetMapping
    public List<Career> findAll() {
        return careerService.findAll();
    }

    @GetMapping("/{id}")
    public Career findById(@PathVariable("id") Long id) {
        Optional<Career> career = careerService.findById(id);
        if (!career.isPresent()) {
            log.error("Id" + id + "does not exist");
        }
        return career.get();
    }

    @PostMapping()
    public void save(@RequestBody Career newCareer) {
        careerService.save(newCareer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        careerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Career updateById(@RequestBody Career newCareer, @PathVariable Long id) {
        Optional<Career> career = careerService.findById(id);

        if (career.isPresent()) {
            newCareer.setId(id);
            careerService.save(newCareer);
            return career.get();
        }

        return newCareer;
    }
}
