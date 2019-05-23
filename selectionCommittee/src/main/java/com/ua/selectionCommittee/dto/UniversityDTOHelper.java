package com.ua.selectionCommittee.dto;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.ua.selectionCommittee.domain.University;

public class UniversityDTOHelper {

	public static University createUniversity(MultipartFile image, String name, String location, String averageScore) throws IOException {
		University unic = new University();
		unic.setAverageScore(Double.parseDouble(averageScore));
		unic.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		unic.setName(name);
		unic.setLocation(location);
		return unic;
	}
}
