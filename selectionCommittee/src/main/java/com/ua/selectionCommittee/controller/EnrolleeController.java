package com.ua.selectionCommittee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ua.dto.EnrolleeDTOHelper;
import com.ua.selectionCommittee.dao.EnrolleeRepository;
import com.ua.selectionCommittee.domain.Administrator;
import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Statement;
import com.ua.selectionCommittee.service.AdministratorService;
import com.ua.selectionCommittee.service.EnrolleeService;
import com.ua.selectionCommittee.service.StatementService;

@Controller
public class EnrolleeController {

	@Autowired
	private EnrolleeService enrolleeService;

	@Autowired
	private EnrolleeRepository enrolleeRepository;

	@Autowired
	private StatementService statementService;

	@RequestMapping(value = "/registrationAdministrator", method = RequestMethod.GET)
	public String registrationAdmin(Model model) {
		model.addAttribute("adminForm", new Administrator());

		return "registrationAdministrator";
	}

	@RequestMapping(value = "/registrationEnrollee", method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String surname, @RequestParam String login, @RequestParam String password,
			@RequestParam String confirmPassword, @RequestParam String mathScore, @RequestParam String englishScore,
			@RequestParam String ukraineScore, @RequestParam String physicsScore) throws IOException {
		enrolleeService.save(EnrolleeDTOHelper.createEnrollee(image, name, surname, login, password, confirmPassword,
				mathScore, englishScore, ukraineScore, physicsScore));
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/editEnrollee", method = RequestMethod.POST)
	public ModelAndView editUser(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String surname, @RequestParam String mathScore,
			@RequestParam String englishScore, @RequestParam String ukraineScore, @RequestParam String physicsScore)
			throws IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginUser = auth.getName();
		Enrollee enrollee = enrolleeService.getByLogin(loginUser);
		Enrollee editedEnrollee = EnrolleeDTOHelper.createEnrollee(image, name, surname, "", "",
				"", mathScore, englishScore, ukraineScore, physicsScore);

		enrollee.setName(editedEnrollee.getName());
		enrollee.setSurname(editedEnrollee.getSurname());
		enrollee.setEnglishScore(editedEnrollee.getEnglishScore());
		enrollee.setMathScore(editedEnrollee.getMathScore());
		enrollee.setPhysicsScore(editedEnrollee.getPhysicsScore());
		enrollee.setUkraineScore(editedEnrollee.getUkraineScore());
		enrollee.setImage(editedEnrollee.getImage());

		enrolleeService.update(enrollee);
		return new ModelAndView("redirect:/home");
	}



	@RequestMapping(value = "/registrationEnrollee", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new Enrollee());

		return "registrationEnrollee";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("enrollees", enrolleeService.getAllRollees());
		return mav;
	}

	@RequestMapping(value = "/enrollee", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) throws IOException {
		Enrollee enrollee = enrolleeRepository.findById(Integer.parseInt(id.replaceAll("\\s", ""))).get();
		statementService.deleteByEnrollee(enrollee);
		enrolleeService.delete(enrollee);
		return welcome();
	}

	@RequestMapping(value = "/enrolleeEdit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String login) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginUser = auth.getName();
		login = login.trim();
		if (loginUser.equals(login)) {
			ModelAndView mav = new ModelAndView("editEnrollee");
			mav.addObject("enrollee", enrolleeService.getByLogin(login));
			return mav;
		}
		return welcome();
	}
}
