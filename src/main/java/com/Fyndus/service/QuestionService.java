package com.Fyndus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.DTO.QuestionDTO;
import com.Fyndus.entity.Question;
import com.Fyndus.entity.Tutor;
import com.Fyndus.respository.QuestionRepository;
import com.Fyndus.respository.TutorRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private TutorRepository tutorRepository;

    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Tutor tutor = tutorRepository.findById(questionDTO.getTutorId())
                .orElseThrow(() -> new IllegalArgumentException("Tutor not found"));
        
        Question question = new Question();
        question.setText(questionDTO.getText());
        question.setTutor(tutor);

        Question savedQuestion = questionRepository.save(question);

        return new QuestionDTO(savedQuestion.getId(), savedQuestion.getText(), 
                savedQuestion.getTutor().getId(), savedQuestion.getTutor().getName());
    }

    public List<QuestionDTO> retrieveQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDTO> questionDTOs = new ArrayList<>();

        for (Question question : questions) {
            questionDTOs.add(new QuestionDTO(question.getId(), question.getText(), 
                    question.getTutor().getId(), question.getTutor().getName()));
        }

        return questionDTOs;
    }
}
