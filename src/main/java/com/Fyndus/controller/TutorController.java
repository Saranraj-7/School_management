package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Fyndus.entity.Tutor;
import com.Fyndus.service.TutorService;

@RestController
@RequestMapping("/api")
public class TutorController {

	@Autowired
	TutorService tutorService;

	@PostMapping("/tutor")
	public Tutor createTutor(@RequestBody Tutor tutor) {
		return tutorService.createTutor(tutor);
	}

	@GetMapping("/tutor")
	public List<Tutor> retriveTutor(Tutor tutor) {
		return tutorService.retriveTutor();
	}

	@GetMapping("/tutorsearch")
	public List<Tutor> searchByTutorNameAndId(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id) {
		if (name != null && id != null) {
			return tutorService.searchByTutorNameAndId(name, id);
		} else if (name != null) {
			return tutorService.searchByName(name);
		} else {
			return tutorService.searchById(id);
		}
	}

}
