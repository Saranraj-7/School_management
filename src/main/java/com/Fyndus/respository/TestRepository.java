package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fyndus.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

	List<Test> findByStudentId(Long studentId);

}
