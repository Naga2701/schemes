package com.project.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.practice.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
