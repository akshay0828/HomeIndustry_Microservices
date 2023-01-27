package com.example.mailsender.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mailsender.entity.EmailMessage;
import com.example.mailsender.repo.emailRepo;
import com.example.mailsender.service.EmailSenderService;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;
    
    
    @Autowired
    private emailRepo emailRepo;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


	@Override
	public void sendEmail(String to, String subject, String message) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("homelandspiceland@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
	}

	@Override

	public void save(EmailMessage  emailMessage ) {
		
		emailRepo.save(emailMessage);
		
		
	}
	
}
