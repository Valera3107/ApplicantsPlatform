package com.ua.selectionCommittee.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.selectionCommittee.config.WebSecurityConfig;
import com.ua.selectionCommittee.dao.EnrolleeRepository;
import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Role;

@Service
public class EnrolleeService {

	private Logger logger = LoggerFactory.getLogger(EnrolleeService.class);

	@Autowired
	private EnrolleeRepository enrolleeRepository;

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	public void save(Enrollee enrollee) throws IOException {
		enrollee.setPassword(webSecurityConfig.passwordEncoder().encode(enrollee.getPassword()));
		enrollee.setPasswordConfirm((webSecurityConfig.passwordEncoder().encode(enrollee.getPasswordConfirm())));
		enrollee.setRole(Role.ROLE_USER);
		logger.info("Save enrollee to DB " + enrollee.toString());
		enrolleeRepository.save(enrollee);
	}
	
	public void update(Enrollee enrollee) throws IOException{
		logger.info("Update enrollee to DB " + enrollee.toString());
		enrolleeRepository.save(enrollee);
	}

	public List<Enrollee> getAllRollees() {
		logger.info("Read all enrollee from DB");
		return enrolleeRepository.findAll();
	}

	public Enrollee getByLogin(String login) {
		logger.info("Get enrollee by login " + login);
		return enrolleeRepository.findByLogin(login).get();
	}
	
	public void delete(Enrollee enrollee) {
		enrolleeRepository.delete(enrollee);
	}
}
