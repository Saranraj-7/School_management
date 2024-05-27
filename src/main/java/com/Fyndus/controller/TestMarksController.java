package com.Fyndus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.entity.TestMarks;
import com.Fyndus.service.TestMarksService;

@RestController
@RequestMapping("/api")
public class TestMarksController {

	@Autowired TestMarksService testMarksService;
	
	 @GetMapping("/marks/{studentId}")
	    public Optional<TestMarks> getMarksForStudent(@PathVariable Long studentId) {
	        return testMarksService.getMarksForStudent(studentId);
	    }
	
}
