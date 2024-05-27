package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fyndus.entity.Choice;
import com.Fyndus.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	void save(Choice choice);
}
