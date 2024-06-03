package com.Fyndus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Fyndus.entity.School;
import com.Fyndus.service.SchoolService;

@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	SchoolService schoolService;

	@PostMapping("/school")
	public School createSchool(@RequestBody School school) {
		return schoolService.createSchool(school);
	}

	@GetMapping("/school")
	public List<School> retriveSchool() {
		return schoolService.retriveSchool();
	}

	@GetMapping("/schoolPage")
	public Page<School> retrieveSchoolPage(@RequestParam int page,
			@RequestParam int size) {
		Pageable pageable = PageRequest.of(page, size);
		return schoolService.retrieveSchoolPage(pageable);
	}
}
