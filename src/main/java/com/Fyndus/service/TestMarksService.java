package com.Fyndus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.entity.TestMarks;
import com.Fyndus.respository.TestMarksRepository;
import com.Fyndus.respository.TestRepository;

@Service
public class TestMarksService {

	@Autowired
	TestMarksRepository testMarksRepository;

	@Autowired
	TestRepository testRepository;

	 public Optional<TestMarks> getMarksForStuOptional(Long studentId) {
	        return testMarksRepository.findById(studentId);
	    }
	
	public Optional<TestMarks> getMarksForStudent(Long studentId) {
		return testMarksRepository.findById(studentId);
	}

	public List<TestMarks> getAllMarks() {
		return testMarksRepository.findAll();
	}

}
