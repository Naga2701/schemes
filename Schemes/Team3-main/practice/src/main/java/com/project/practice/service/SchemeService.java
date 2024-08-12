package com.project.practice.service;

import com.project.practice.model.Scheme;
import com.project.practice.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    public Scheme createScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    public List<Scheme> getFilteredSchemes(String category, String gender, String ageRange, String caste,
                                           String residence, String differentlyAbled, String bplStatus, String employmentStatus) {
        return schemeRepository.findAll(Specification.where(buildSpecification(category, gender, ageRange, caste, residence, differentlyAbled, bplStatus, employmentStatus)));
    }

    private Specification<Scheme> buildSpecification(String category, String gender, String ageRange, String caste,
                                                     String residence, String differentlyAbled, String bplStatus, String employmentStatus) {
        return (root, query, criteriaBuilder) -> {
            Specification<Scheme> spec = Specification.where(null);

            if (category != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("category"), category));
            }
            if (gender != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("gender"), gender));
            }
            if (ageRange != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("ageRange"), ageRange));
            }
            if (caste != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("caste"), caste));
            }
            if (residence != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("residence"), residence));
            }
            if (differentlyAbled != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("differentlyAbled"), differentlyAbled));
            }
            if (bplStatus != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("bplStatus"), bplStatus));
            }
            if (employmentStatus != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("employmentStatus"), employmentStatus));
            }

            return spec.toPredicate(root, query, criteriaBuilder);
        };
    }

    public Optional<Scheme> getSchemeById(Long id) {
        return schemeRepository.findById(id);
    }

    public void deleteScheme(Long id) {
        schemeRepository.deleteById(id);
    }

    public Scheme updateScheme(Long id, Scheme schemeDetails) {
        Optional<Scheme> optionalScheme = schemeRepository.findById(id);
        if (optionalScheme.isPresent()) {
            Scheme existingScheme = optionalScheme.get();
            existingScheme.setName(schemeDetails.getName());
            existingScheme.setDescription(schemeDetails.getDescription());
            // Set other fields similarly
            return schemeRepository.save(existingScheme);
        } else {
            return null;
        }
    }
}
