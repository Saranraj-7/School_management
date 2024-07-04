package com.Fyndus.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.MarksDTO;
import com.Fyndus.entity.Student;
import com.Fyndus.service.MarksService;
import com.Fyndus.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	MarksService marksService;

	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.createStudent(student);
		return ResponseEntity.ok(createdStudent);
	}

	@GetMapping("/student")
	public List<Student> retriveStudent(Student student) {
		return this.studentService.retriveStudent(student);
	}
	
	@GetMapping("/student/total-marks/{studentId}")
	public ResponseEntity<MarksDTO> getStudentTotalMarks(@PathVariable Long studentId) {
		MarksDTO studentMarksDTO = marksService.getStudentTotalMarks(studentId);
		if (studentMarksDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(studentMarksDTO);
	}

	@GetMapping("/student/search")
	public List<Student> findByName(@RequestParam String name) {
		return this.studentService.searchByName(name);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id, @RequestParam(required = false) Long schoolId,
			@RequestParam(required = false) String schoolName) {
		List<Student> students = studentService.searchStudents(name, id, schoolId, schoolName);
		return ResponseEntity.ok(students);
	}
}
