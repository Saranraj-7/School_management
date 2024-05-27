	package com.Fyndus.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import com.Fyndus.entity.Student;
	import com.Fyndus.service.StudentService;
	
	@RestController
	@RequestMapping("/api")
	public class StudentController {
	
		@Autowired StudentService studentService;
		
		
		@PostMapping("/student")
		
		public Student createStudent(@RequestBody Student student) {
			return this.studentService.createStudent(student);
		}
		
		@GetMapping("/student")
		public List<Student> retriveStudent(Student student) {
			return this.studentService.retriveStudent(student);
		}
		
	
		
		
		
			
		
	}
