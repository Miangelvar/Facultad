package com.example.onetomany.controller;

import com.example.onetomany.entity.Faculty;
import com.example.onetomany.service.FacultyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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

    @PostMapping()
    public void save(@RequestBody Faculty newFaculty) {
        facultyService.save(newFaculty);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        facultyService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@RequestBody Faculty newFaculty, @PathVariable Long id) {
        facultyService.findById(id)
            .map(faculty -> {
                faculty.setName(newFaculty.getName());
                facultyService.save(faculty);
                return null;
            })
            .orElseGet(() -> {
                newFaculty.setId(id);
                facultyService.save(newFaculty);
                return null;
            });
    }

}
