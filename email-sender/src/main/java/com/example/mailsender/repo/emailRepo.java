package com.example.mailsender.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mailsender.entity.EmailMessage;

@Repository
public interface emailRepo extends JpaRepository<EmailMessage, Integer> {

}
