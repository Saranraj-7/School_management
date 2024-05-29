package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Fyndus.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

	   @Query("SELECT t FROM Test t WHERE t.student.id = ?1")
	    List<Test> findByStudentId(Long studentId);
}
