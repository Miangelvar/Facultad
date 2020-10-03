package com.example.onetomany.controller;

import com.example.onetomany.entity.Faculty;
import com.example.onetomany.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/faculties")
@Slf4j
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public List<Faculty> findAll() {
        return facultyService.findAll();
    }

    @GetMapping("/{id}")
    public Faculty findById(@PathVariable("id") Long id) {
        Optional<Faculty> faculty = facultyService.findById(id);
        if (!faculty.isPresent()) {
            log.error("Id" + id + "does not exist");
        }
        return faculty.get();
    }

    @PostMapping
    public void save(@RequestBody Faculty newFaculty) {
        facultyService.save(newFaculty);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        facultyService.deleteById(id);
    }

}
