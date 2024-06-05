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
	public List<School> retrieveSchoolPage(@RequestParam int page, @RequestParam int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<School> schoolPage = schoolService.retrieveSchoolPage(pageable);
		return schoolPage.getContent();
	}

	@GetMapping("/schoolsearch")
	public List<School> searchByNameAndId(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id) {
		if (name != null && id != null) {
			return schoolService.searchByNameAndId(name, id);
		} else if (name != null) {
			return schoolService.searchByName(name);
		} else {
			return schoolService.searchById(id);
		}
	}

}
