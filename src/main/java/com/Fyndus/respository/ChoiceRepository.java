package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

}
