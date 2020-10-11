package com.example.onetomany.controller;

import com.example.onetomany.entity.Dean;
import com.example.onetomany.entity.Dean;
import com.example.onetomany.service.DeanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/deans")
@Slf4j
public class DeanController {

    private final DeanService deanService;

    @GetMapping
    public List<Dean> findAll() {
        return deanService.findAll();
    }

    @GetMapping("/{id}")
    public Dean findById(@PathVariable("id") Long id) {
        Optional<Dean> dean = deanService.findById(id);
        if (!dean.isPresent()) {
            log.error("Id" + id + "does not exist");
        }
        return dean.get();
    }

    @PostMapping()
    public void save(@RequestBody Dean newDean) {
        deanService.save(newDean);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        deanService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Dean updateById(@RequestBody Dean newDean, @PathVariable Long id) {
        Optional<Dean> dean = deanService.findById(id);

        if (dean.isPresent()) {
            newDean.setId(id);
            deanService.save(newDean);
            return dean.get();
        }

        return newDean;
    }
}
