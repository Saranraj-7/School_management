package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.TestDTO;
import com.Fyndus.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired 
    private TestService testService;
    
    @PostMapping("/test")
    public TestDTO createTest(@RequestBody TestDTO testDTO) {
        return testService.createTest(testDTO);
    }
    
    @GetMapping("/tests")
    public List<TestDTO> retrieveTests() {
        return testService.retrieveTests();
    }
}
