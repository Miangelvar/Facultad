package com.example.onetomany.controller;

import com.example.onetomany.entity.Course;
import com.example.onetomany.entity.Course;
import com.example.onetomany.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable("id") Long id) {
        Optional<Course> course = courseService.findById(id);
        if (!course.isPresent()) {
            log.error("Id" + id + "does not exist");
        }
        return course.get();
    }

    @PostMapping()
    public void save(@RequestBody Course newCourse) {
        courseService.save(newCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Course updateById(@RequestBody Course newCourse, @PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);

        if (course.isPresent()) {
            newCourse.setId(id);
            courseService.save(newCourse);
            return course.get();
        }

        return newCourse;
    }
}
