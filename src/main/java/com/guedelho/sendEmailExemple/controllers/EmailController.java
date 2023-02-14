package com.guedelho.sendEmailExemple.controllers;

import com.guedelho.sendEmailExemple.dto.Email;
import com.guedelho.sendEmailExemple.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/emails")
@CrossOrigin(origins = "*")
public class EmailController {
    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping
    public ResponseEntity<Email> send(@RequestBody Email email) {
        return ResponseEntity.ok(sendEmailService.send(email));
    }
}
