package com.Fyndus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.entity.Tutor;
import com.Fyndus.service.TutorService;

@RestController
@RequestMapping("/api")
public class TutorController {

	@Autowired TutorService tutorService;
	
	@PostMapping("/tutor")
	public Tutor createTutor(@RequestBody Tutor tutor) {
		return tutorService.createTutor(tutor);
	}
	
	@GetMapping("/tutor")
	public List<Tutor> retriveTutor(Tutor tutor){
		return tutorService.retriveTutor();
	}
	
	@GetMapping("/tutor/{id}")
	public Optional<Tutor> tutorById(@PathVariable long id){
		return tutorService.tutorById(id);
	}
}
