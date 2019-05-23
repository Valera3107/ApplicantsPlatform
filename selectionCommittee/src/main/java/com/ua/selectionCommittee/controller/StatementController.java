package com.ua.selectionCommittee.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Statement;
import com.ua.selectionCommittee.domain.University;
import com.ua.selectionCommittee.service.EnrolleeService;
import com.ua.selectionCommittee.service.StatementService;
import com.ua.selectionCommittee.service.UniversityService;

@Controller
public class StatementController {

	@Autowired
	private EnrolleeService enrolleeService;

	@Autowired
	private StatementService statementService;

	@Autowired
	private UniversityService universityService;

	@RequestMapping(value = "/statement", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String facultyId) {
		University university = universityService.findById(Integer.parseInt(facultyId));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		Enrollee enrollee = enrolleeService.getByLogin(login);

		if (enrollee.getStatus().equals("enrollee") && university.getAverageScore() < ((enrollee.getEnglishScore()
				+ enrollee.getMathScore() + enrollee.getUkraineScore() + enrollee.getPhysicsScore()) / 4)) {
			Statement statement = new Statement();
			enrollee.setStatus("Student of the " + university.getName() + " faculty.");
			statement.setEnrollee(enrollee);
			statement.setReceiptDate(new Date());
			statement.setUniversity(university);
			statementService.save(statement);
		}
		return getStatementItems();
	}

	@RequestMapping(value = "/statements", method = RequestMethod.GET)
	public ModelAndView welcomeStatemnet() {
		return getStatementItems();
	}

	@RequestMapping(value = "/statement", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) throws IOException {
		Statement statement = statementService.findById(Integer.parseInt(id.replaceAll("\\s", "")));
		Enrollee enrollee = statement.getEnrollee();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login = auth.getName();
		if (login.equals(enrollee.getLogin())) {
			enrollee.setStatus("enrollee");
			enrolleeService.update(enrollee);
			statementService.delete(statement);
		}
		return getStatementItems();
	}

	private ModelAndView getStatementItems() {
		ModelAndView mav = new ModelAndView("statement");
		mav.addObject("statements", statementService.getAllStatements());
		return mav;
	}
}
