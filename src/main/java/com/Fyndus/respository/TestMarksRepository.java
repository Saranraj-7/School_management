package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Fyndus.entity.TestMarks;

public interface TestMarksRepository extends JpaRepository<TestMarks, Long	> {

	
}
