package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.entity.Question;
import com.Fyndus.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@PostMapping("/question")
	public Question createQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}

	@GetMapping("/question")
	public List<Question> retriveQuestion(Question question) {
		return questionService.retriveQuestion(question);
	}
}
