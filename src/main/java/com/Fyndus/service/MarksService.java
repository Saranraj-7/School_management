package com.Fyndus.service;

import com.Fyndus.DTO.MarksDTO;
import com.Fyndus.entity.Student;
import com.Fyndus.entity.Test;
import com.Fyndus.respository.StudentRepository;
import com.Fyndus.respository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

    @Autowired
    private TestRepository testRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Test> getTestsByStudentId(Long studentId) {
        return testRepository.findByStudentId(studentId);
    }

    public Long calculateTotalPointsForStudent(Long studentId) {
        List<Test> tests = getTestsByStudentId(studentId);
        long totalPoints = 0;
        for (Test test : tests) {
            if (test.getChoice() != null && test.getChoice().getPoint() != null) {
                totalPoints += test.getChoice().getPoint();
            }
        }
        return totalPoints;
    }

    public Test saveTest(Test test) {
        return testRepository.save(test);
    }
    
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
    
    public MarksDTO getStudentTotalMarks(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            return null;
        }
        Long totalPoints = calculateTotalPointsForStudent(studentId);
        return new MarksDTO(student.getId(), student.getName(), totalPoints);
    }
    
    public List<MarksDTO> getAllStudentsTotalMarks() {
        List<Student> students = studentRepository.findAll();
        List<MarksDTO> studentMarksDTOList = new ArrayList<>();

        for (Student student : students) {
            Long totalPoints = calculateTotalPointsForStudent(student.getId());
            MarksDTO studentMarksDTO = new MarksDTO(student.getId(), student.getName(), totalPoints);
            studentMarksDTOList.add(studentMarksDTO);
        }

        return studentMarksDTOList;
    }
}
