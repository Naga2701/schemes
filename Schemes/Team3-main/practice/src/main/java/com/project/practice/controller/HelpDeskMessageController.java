package com.project.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.practice.model.HelpDeskMessage;
import com.project.practice.service.HelpDeskMessageService;

import java.util.List;

@RestController
@RequestMapping("/helpdesk")
@CrossOrigin(origins = "*")
public class HelpDeskMessageController {

    @Autowired
    private HelpDeskMessageService helpDeskMessageService;

    @PostMapping
    public ResponseEntity<HelpDeskMessage> createMessage(@RequestBody HelpDeskMessage message) {
        HelpDeskMessage createdMessage = helpDeskMessageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    @GetMapping
    public ResponseEntity<List<HelpDeskMessage>> getAllMessages() {
        List<HelpDeskMessage> messages = helpDeskMessageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        helpDeskMessageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}
