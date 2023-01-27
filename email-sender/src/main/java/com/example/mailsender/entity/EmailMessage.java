package com.example.mailsender.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String from;
    private String to;
    private String subject;
    private String message;
    private Boolean mailstatus;
    private String category;
	public EmailMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailMessage(String from, String to, String subject, String message, Boolean mailstatus, String category) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.mailstatus = mailstatus;
		this.category = category;
	}
	public EmailMessage(int id, String from, String to, String subject, String message, Boolean mailstatus,
			String category) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.mailstatus = mailstatus;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getMailstatus() {
		return mailstatus;
	}
	public void setMailstatus(Boolean mailstatus) {
		this.mailstatus = mailstatus;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "EmailMessage [id=" + id + ", from=" + from + ", to=" + to + ", subject=" + subject + ", message="
				+ message + ", mailstatus=" + mailstatus + ", category=" + category + "]";
	}
    
    
    
    
    
}