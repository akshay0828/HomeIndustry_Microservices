package com.example.mailsender.service;

import com.example.mailsender.entity.EmailMessage;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);

	void save(EmailMessage emailMessage);
}
