package com.ua.selectionCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.selectionCommittee.dao.UniversityRepository;
import com.ua.selectionCommittee.domain.University;

@Service
public class UniversityService {
	
	private Logger logger = LoggerFactory.getLogger(UniversityService.class);

	@Autowired
	private UniversityRepository universityRepository; 
	
	public University save(University university) {
		logger.info("Save university to DB " + university.toString());
		return universityRepository.save(university);
	}
	
	public List<University> getAlluniversitys(){
		logger.info("Read all university items from DB");
		return universityRepository.findAll();
	}
	
	public University findById(Integer id) {
		logger.info("Find university from DB by id " + id);
		return universityRepository.findById(id).get();
	}
}
