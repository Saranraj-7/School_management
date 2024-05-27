package com.Fyndus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.entity.Choice;
import com.Fyndus.respository.ChoiceRepository;

@Service
public class ChoiceService {
	@Autowired
	ChoiceRepository choiceRepository;

	
	public Choice createChoice(Choice choice) {
		return choiceRepository.save(choice);
	}

	public List<Choice> retriveChoice(Choice choice) {
		return choiceRepository.findAll();
	}
	

}
