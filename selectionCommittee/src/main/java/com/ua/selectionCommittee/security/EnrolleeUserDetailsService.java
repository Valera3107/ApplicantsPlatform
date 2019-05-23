package com.ua.selectionCommittee.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ua.selectionCommittee.dao.AdministratorRepository;
import com.ua.selectionCommittee.dao.EnrolleeRepository;
import com.ua.selectionCommittee.domain.Administrator;
import com.ua.selectionCommittee.domain.Enrollee;

@Service("UserDetailsService")
public class EnrolleeUserDetailsService implements UserDetailsService{

	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	@Autowired
	private AdministratorRepository administratorRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Enrollee> enrolleeOptional = enrolleeRepository.findByLogin(login);
        Optional<Administrator> administratorOptional = administratorRepository.findByLogin(login);
		
		if(enrolleeOptional.isPresent()) {
			Enrollee enrollee = enrolleeOptional.get();
			return new EnrolleeUserDetails(enrollee, Collections.singletonList(enrollee.getRole().toString()));
		} else if(administratorOptional.isPresent()) {
			Administrator administrator = administratorOptional.get();
			return new AdministrationDetails(administrator, Collections.singletonList(administrator.getRole().toString()));
		}
		
		throw new UsernameNotFoundException("No user present with user login " + login);
	}
}
