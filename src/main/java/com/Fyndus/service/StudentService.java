package com.Fyndus.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Fyndus.entity.Student;
import com.Fyndus.respository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> retriveStudent(Student student) {
		return studentRepository.findAll();
	}

	public Optional<Student> studentById(Long id) {
		return studentRepository.findById(id);
	}

	public List<Student> searchByName(String name) {
		return studentRepository.findByName(name);
	}

	public List<Student> searchStudents(String name, Long id, Long schoolId, String schoolName) {
		return studentRepository.searchByCriteria(name, id, schoolId, schoolName);
	}

}
