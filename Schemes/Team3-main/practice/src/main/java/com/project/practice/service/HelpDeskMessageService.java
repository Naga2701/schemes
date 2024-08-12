package com.project.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.practice.model.HelpDeskMessage;
import com.project.practice.repository.HelpDeskMessageRepository;

import java.util.List;

@Service
public class HelpDeskMessageService {

    @Autowired
    private HelpDeskMessageRepository helpDeskMessageRepository;

    public HelpDeskMessage createMessage(HelpDeskMessage message) {
        return helpDeskMessageRepository.save(message);
    }

    public List<HelpDeskMessage> getAllMessages() {
        return helpDeskMessageRepository.findAll();
    }

    public void deleteMessage(Long id) {
        helpDeskMessageRepository.deleteById(id);
    }
}
