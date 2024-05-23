package com.Fyndus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.entity.Question;
import com.Fyndus.respository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired QuestionRepository questionRepository;
	
	public Question createQuestion(Question question) {
		return questionRepository.save( question);
	}
	
	public List<Question> retriveQuestion(Question question) {
		return questionRepository.findAll();
	}

}
