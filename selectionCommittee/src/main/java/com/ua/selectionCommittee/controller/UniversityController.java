package com.ua.selectionCommittee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ua.dto.UniversityDTOHelper;
import com.ua.selectionCommittee.dao.UniversityRepository;
import com.ua.selectionCommittee.domain.University;
import com.ua.selectionCommittee.service.UniversityService;
import com.zaxxer.hikari.util.SuspendResumeLock;

@Controller
public class UniversityController {

	@Autowired
	private UniversityService universityService;

	@Autowired
	private UniversityRepository universityRepository;

	@RequestMapping(value = "faculty", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) throws IOException {
		universityRepository.deleteById(Integer.parseInt(id));
		return welcome();
	}

	@RequestMapping(value = "/createUniversity", method = RequestMethod.GET)
	public String registrationAdmin(Model model) {
		return "createUniversity";
	}

	@RequestMapping(value = "/createUniversity", method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String location, @RequestParam String averageScore) throws IOException {
		universityService.save(UniversityDTOHelper.createUniversity(image, name, location, averageScore));
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/faculties", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("faculties");
		mav.addObject("faculties", universityService.getAlluniversitys());
		return mav;
	}
	
	@RequestMapping(value = "/facultyEdit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam String name) throws IOException {
		University faculty = universityRepository.getByName(name);
		ModelAndView mav = new ModelAndView("facultyEdit");
		mav.addObject("faculty", faculty);
		return mav;
	}

	@RequestMapping(value = "/facultyEdit", method = RequestMethod.POST)
	public ModelAndView editFacultyInfo(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String location, @RequestParam String averageScore, @RequestParam String id) throws IOException {
		University unic = universityService.findById(Integer.parseInt(id));
		System.out.println(unic);
		University unicEdit = UniversityDTOHelper.createUniversity(image, name, location, averageScore);
		unic.setAverageScore(unicEdit.getAverageScore());
		unic.setImage(unicEdit.getImage());
		unic.setLocation(unicEdit.getLocation());
		unic.setName(unicEdit.getName());
		System.out.println(unic);
		universityService.save(unic);
		return new ModelAndView("redirect:/faculties");
	}
}
