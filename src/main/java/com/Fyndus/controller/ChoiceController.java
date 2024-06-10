package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.ChoiceDTO;
import com.Fyndus.service.ChoiceService;

@RestController
@RequestMapping("/api/choices")
@CrossOrigin(origins = "http://localhost:3000/")
public class ChoiceController {

	@Autowired
	private ChoiceService choiceService;

	@PostMapping("/choice")
	public ChoiceDTO createChoice(@RequestBody ChoiceDTO choiceDTO) {
		return choiceService.createChoice(choiceDTO);
	}

	@GetMapping("/choices")
	public List<ChoiceDTO> retrieveChoices() {
		return choiceService.retrieveChoices();
	}
}