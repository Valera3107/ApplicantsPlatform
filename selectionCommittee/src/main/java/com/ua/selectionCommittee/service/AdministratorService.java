package com.ua.selectionCommittee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.selectionCommittee.config.WebSecurityConfig;
import com.ua.selectionCommittee.dao.AdministratorRepository;
import com.ua.selectionCommittee.domain.Administrator;
import com.ua.selectionCommittee.domain.Role;

@Service
public class AdministratorService {
	private Logger logger = LoggerFactory.getLogger(AdministratorService.class);

	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;
	
	public void save(Administrator administrator) {
		administrator.setPassword(webSecurityConfig.passwordEncoder().encode(administrator.getPassword()));
		administrator.setPasswordConfirm((webSecurityConfig.passwordEncoder().encode(administrator.getPasswordConfirm())));
		administrator.setRole(Role.ROLE_ADMIN);
		logger.info("Save administrator to DB " + administrator);
		administratorRepository.save(administrator);
	}
}
