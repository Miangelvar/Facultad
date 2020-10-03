package com.example.onetomany.controller;

import com.example.onetomany.entity.Career;
import com.example.onetomany.entity.Student;
import com.example.onetomany.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            log.error("Id" + id + "does not exist");
        }
        return student.get();
    }

    @PostMapping
    public void save(@RequestBody Student newStudent) {
        studentService.save(newStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }
}
