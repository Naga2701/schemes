package com.project.practice.controller;

import com.project.practice.model.Scheme;
import com.project.practice.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public ResponseEntity<List<Scheme>> getAllSchemes(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String ageRange,
            @RequestParam(required = false) String caste,
            @RequestParam(required = false) String residence,
            @RequestParam(required = false) String differentlyAbled,
            @RequestParam(required = false) String bplStatus,
            @RequestParam(required = false) String employmentStatus) {

        List<Scheme> schemes = schemeService.getFilteredSchemes(
            category, gender, ageRange, caste, residence, differentlyAbled, bplStatus, employmentStatus);
        return ResponseEntity.ok(schemes);
    }

    @PostMapping
    public ResponseEntity<Scheme> createScheme(@RequestBody Scheme scheme) {
        Scheme createdScheme = schemeService.createScheme(scheme);
        return ResponseEntity.ok(createdScheme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheme> updateScheme(@PathVariable Long id, @RequestBody Scheme scheme) {
        Scheme updatedScheme = schemeService.updateScheme(id, scheme);
        if (updatedScheme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedScheme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheme(@PathVariable Long id) {
        schemeService.deleteScheme(id);
        return ResponseEntity.ok().build();
    }
}
