package com.Fyndus.controller;

import com.Fyndus.DTO.MarksDTO;
import com.Fyndus.service.MarksService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "http://localhost:3000/")
public class MarksController {

	@Autowired
	private MarksService marksService;

	@GetMapping("/student/total-marks/{studentId}")
	public ResponseEntity<MarksDTO> getStudentTotalMarks(@PathVariable Long studentId) {
		MarksDTO studentMarksDTO = marksService.getStudentTotalMarks(studentId);
		if (studentMarksDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(studentMarksDTO);
	}
	
	   @GetMapping("/students/total-marks")
	    public ResponseEntity<List<MarksDTO>> getAllStudentsTotalMarks() {
	        List<MarksDTO> studentMarksDTOList = marksService.getAllStudentsTotalMarks();
	        return ResponseEntity.ok(studentMarksDTOList);
	    }

}
