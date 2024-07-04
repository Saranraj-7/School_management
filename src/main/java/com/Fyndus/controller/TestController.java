package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Fyndus.entity.Test;
import com.Fyndus.service.TestService;

@RestController
@RequestMapping("/api/tests")
public class TestController {

	@Autowired
	private TestService testService;

	@PostMapping("/test")
	public Test createTest(@RequestBody Test test) {
		return testService.createTest(test);
	}

	@GetMapping("/tests")
	public List<Test> retrieveTests() {
		return testService.retriveTest();
	}
}
