package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fyndus.DTO.QuestionDTO;
import com.Fyndus.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<QuestionDTO> findByTextContainingIgnoreCase(String text);

}
