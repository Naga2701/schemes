package com.project.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.practice.model.HelpDeskMessage;

public interface HelpDeskMessageRepository extends JpaRepository<HelpDeskMessage, Long> {
}
