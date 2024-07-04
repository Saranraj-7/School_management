package com.Fyndus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Fyndus.entity.School;
import com.Fyndus.service.SchoolService;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

	@Autowired
	SchoolService schoolService;

	@PostMapping("/create")
	public ResponseEntity<School> createSchool(@RequestBody School school) {
		School createdSchool = schoolService.createSchool(school);
		return ResponseEntity.ok(createdSchool);
	}

	@GetMapping("/retrievePage")
	public List<School> retrieveSchoolPage(@RequestParam int page, @RequestParam int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<School> schoolPage = schoolService.retrieveSchoolPage(pageable);
		return schoolPage.getContent();
	}

	@GetMapping("/search")
	public ResponseEntity<List<School>> searchSchools(@RequestParam("search") String search) {
		List<School> schools = schoolService.searchSchools(search);
		return ResponseEntity.ok(schools);
	}

}
