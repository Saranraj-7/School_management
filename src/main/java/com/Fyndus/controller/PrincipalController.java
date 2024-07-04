package com.Fyndus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.SchoolDataResponse;
import com.Fyndus.entity.Student;
import com.Fyndus.entity.Tutor;
import com.Fyndus.service.StudentService;
import com.Fyndus.service.TutorService;

@RestController
@RequestMapping("/api/principal")
public class PrincipalController {

	@Autowired
	StudentService studentService;

	@Autowired
	TutorService tutorService;

	@GetMapping("/schooldata")
	public SchoolDataResponse getSchoolData() {
		List<Student> students = studentService.getAllStudents();
		List<Tutor> staff = tutorService.getAllStaff();
		return new SchoolDataResponse(students, staff);
	}
}
