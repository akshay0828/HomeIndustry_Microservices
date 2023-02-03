package com.example.mailsender.controller;

import com.example.mailsender.entity.EmailMessage;
import com.example.mailsender.repo.emailRepo;
import com.example.mailsender.service.EmailSenderService;

import java.util.Optional;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private emailRepo emailRepo;

	@GetMapping("/get/{id}")

	public EmailMessage get(@PathVariable int id) {

		return emailRepo.findById(id).get();
	}

	@PostMapping("/email")

	public String mail(@RequestParam("to") String to, @RequestParam("subject") String subject,
			@RequestParam("message") String message) throws Exception {

//    	public String mail(String to, String subject, String message) throws Exception {

		EmailMessage email = new EmailMessage("homelandspiceland@gmail.com", to, subject, message, true, "ADD_PRODUCT");

		emailSenderService.sendEmail(to, subject, message);

//        	emailSenderService.save(email);

		return "success";

	}

}
