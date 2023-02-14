package com.guedelho.sendEmailExemple.services;

import com.guedelho.sendEmailExemple.core.EnvironmentVariable;
import com.guedelho.sendEmailExemple.dto.Email;
import com.guedelho.sendEmailExemple.enums.Status;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EnvironmentVariable environmentVariable;
    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailService.class);

    public Email send(Email email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mailMessage.setFrom("Aplicação <" + environmentVariable.getEmailFrom() + ">");
            mailMessage.setTo(email.getTo());
            mimeMessage.setContent(email.getBody(), "text/html;charset=UTF-8");
            mailMessage.setSubject(email.getSubject());

            javaMailSender.send(mimeMessage);
            email.setStatus(Status.SENT);
        } catch (Exception ex) {
            LOGGER.error("send - Error: " + ex.getMessage());
            email.setStatus(Status.ERROR);
        } finally {
            return email;
        }
    }
}
