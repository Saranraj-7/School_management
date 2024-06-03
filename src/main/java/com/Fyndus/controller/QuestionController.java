package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Fyndus.DTO.QuestionDTO;
import com.Fyndus.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping("/question")
	public QuestionDTO createQuestion(@RequestBody QuestionDTO questionDTO) {
		return questionService.createQuestion(questionDTO);
	}

	@GetMapping("/question")
	public List<QuestionDTO> getQuestion() {
		return questionService.retrieveQuestions();
	}
}
