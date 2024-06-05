package com.Fyndus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.DTO.TestDTO;
import com.Fyndus.entity.Test;
import com.Fyndus.respository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;

	// Method to convert TestDTO to Test entity
	private Test toEntity(TestDTO testDTO) {
		Test test = new Test();
		test.setId(testDTO.getId());
		// Set other properties similarly
		return test;
	}

	// Method to convert Test entity to TestDTO
	private TestDTO toDTO(Test test) {
		TestDTO testDTO = new TestDTO(0, null, null);
		testDTO.setId(test.getId());
		// Set other properties similarly
		return testDTO;
	}

	public TestDTO createTest(TestDTO testDTO) {
		Test test = toEntity(testDTO);
		Test savedTest = testRepository.save(test);
		return toDTO(savedTest);
	}

	public List<TestDTO> retrieveTests() {
		List<Test> tests = testRepository.findAll();
		List<TestDTO> testDTOs = new ArrayList<>();
		for (Test test : tests) {
			testDTOs.add(toDTO(test));
		}
		return testDTOs;
	}

}
