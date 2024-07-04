package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.MarksDTO;
import com.Fyndus.entity.Tutor;
import com.Fyndus.service.MarksService;
import com.Fyndus.service.TutorService;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

	@Autowired
	TutorService tutorService;

	@Autowired
	MarksService marksService;

	@PostMapping("/tutor")
	public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
		Tutor createTutor = tutorService.createTutor(tutor);
		return ResponseEntity.ok(createTutor);
	}

	@GetMapping("/tutor")
	public List<Tutor> retriveTutor(Tutor tutor) {
		return tutorService.retriveTutor();
	}

	@GetMapping("/students/total-marks")
	public ResponseEntity<List<MarksDTO>> getAllStudentsTotalMarks() {
		List<MarksDTO> studentMarksDTOList = marksService.getAllStudentsTotalMarks();
		return ResponseEntity.ok(studentMarksDTOList);
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
