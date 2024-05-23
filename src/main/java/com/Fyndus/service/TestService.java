package com.Fyndus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.entity.Test;
import com.Fyndus.respository.TestRepository;

@Service
public class TestService {

	@Autowired TestRepository testRepository;
	
	
	public Test createTest(Test test) {
		return testRepository.save(test);
	}
	
	public List<Test> retriveTest(Test test) {
		return testRepository.findAll();
	}
}
