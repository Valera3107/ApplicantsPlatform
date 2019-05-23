package com.ua.selectionCommittee.dto;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.ua.selectionCommittee.domain.Enrollee;

public class EnrolleeDTOHelper {
	public static Enrollee createEnrollee(MultipartFile image, String name, String surname, String login,
			String password, String confirmPassword, String mathScore, String englishScore, String ukraineScore,
			String physicsScore) throws IOException {
		Enrollee enrollee = new Enrollee();
		enrollee.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		enrollee.setEnglishScore(Double.parseDouble(englishScore));
		enrollee.setMathScore(Double.parseDouble(mathScore));
		enrollee.setUkraineScore(Double.parseDouble(ukraineScore));
		enrollee.setPhysicsScore(Double.parseDouble(physicsScore));
		enrollee.setLogin(login);
		enrollee.setPassword(password);
		enrollee.setPasswordConfirm(confirmPassword);
		enrollee.setName(name);
		enrollee.setSurname(surname);
		enrollee.setStatus("enrollee");
		return enrollee;
	}
}
