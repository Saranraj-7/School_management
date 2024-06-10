package com.Fyndus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.DTO.ChoiceDTO;
import com.Fyndus.entity.Choice;
import com.Fyndus.respository.ChoiceRepository;

@Service
public class ChoiceService {

	@Autowired
	private ChoiceRepository choiceRepository;

	private Choice toEntity(ChoiceDTO choiceDTO) {
		Choice choice = new Choice();
		choice.setId(choiceDTO.getId());
		choice.setChoices(choiceDTO.getChoices());
		choice.setIsCorrect(choiceDTO.getIsCorrect());
		return choice;
	}

	private ChoiceDTO toDTO(Choice choice) {
		return new ChoiceDTO(choice.getId(), choice.getChoices(), choice.getIsCorrect());
	}

	public ChoiceDTO createChoice(ChoiceDTO choiceDTO) {
		Choice choice = toEntity(choiceDTO);
		Choice savedChoice = choiceRepository.save(choice);
		return toDTO(savedChoice);
	}

	public List<ChoiceDTO> retrieveChoices() {
		List<Choice> choices = choiceRepository.findAll();
		List<ChoiceDTO> choiceDTOs = new ArrayList<>();

		for (Choice choice : choices) {
			choiceDTOs.add(toDTO(choice));
		}

		return choiceDTOs;
	}
}
