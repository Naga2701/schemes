package com.project.practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schemes")
public class Scheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    // New filter attributes
    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "age_range", nullable = true)
    private String ageRange;

    @Column(name = "caste", nullable = true)
    private String caste;

    @Column(name = "residence", nullable = true)
    private String residence;

    @Column(name = "differently_abled", nullable = true)
    private String differentlyAbled;

    @Column(name = "bpl_status", nullable = true)
    private String bplStatus;

    @Column(name = "employment_status", nullable = true)
    private String employmentStatus;

    
    // Constructors, Getters, and Setters
    public Scheme() {}

    public Scheme(String name, String description, String category, String gender, String ageRange, String caste,
                  String residence, String differentlyAbled, String bplStatus, String employmentStatus) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.gender = gender;
        this.ageRange = ageRange;
        this.caste = caste;
        this.residence = residence;
        this.differentlyAbled = differentlyAbled;
        this.bplStatus = bplStatus;
        this.employmentStatus = employmentStatus;
    }
    
    // Getters and Setters for all fields
    // ...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getDifferentlyAbled() {
        return differentlyAbled;
    }

    public void setDifferentlyAbled(String differentlyAbled) {
        this.differentlyAbled = differentlyAbled;
    }

    public String getBplStatus() {
        return bplStatus;
    }

    public void setBplStatus(String bplStatus) {
        this.bplStatus = bplStatus;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
