package com.ua.selectionCommittee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.selectionCommittee.dao.StatementRepository;
import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Statement;

@Service
public class StatementService {
	private Logger logger = LoggerFactory.getLogger(StatementService.class);

	@Autowired
	private StatementRepository statementRepository;

	public List<Statement> getAllStatements() {
		logger.info("Get all statements from DB");
		return statementRepository.findAll();
	}

	public Statement findById(Integer id) {
		logger.info("Find statement by id: " + id);
		return statementRepository.findById(id).get();
	}

	public Statement save(Statement statement) {
		logger.info("Save statement to DB " + statement.toString());
		return statementRepository.save(statement);
	}

	public void delete(Statement statement) {
		logger.info("Delete statement by id " + statement.getId());
		statementRepository.delete(statement);
	}

	public void deleteByEnrollee(Enrollee enrollee) {
		logger.info("Delete statement by enrollee " + enrollee.toString());
		Optional<Statement> statement = getAllStatements().stream()
				.filter(e -> e.getEnrollee().getId().equals(enrollee.getId())).findFirst();
		if (statement.isPresent()) {
			delete(statement.get());
		}
	}
}
