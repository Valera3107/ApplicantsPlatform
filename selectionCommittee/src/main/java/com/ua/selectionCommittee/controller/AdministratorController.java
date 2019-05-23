package com.ua.selectionCommittee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ua.selectionCommittee.domain.Administrator;
import com.ua.selectionCommittee.service.AdministratorService;

@Controller
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@RequestMapping(value = "/registrationAdministrator", method = RequestMethod.POST)
	public String registrationAdmin(@ModelAttribute("adminForm") Administrator userForm, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "registrationAdministrator";
		}
		administratorService.save(userForm);

		return "redirect:/home";
	}
}
