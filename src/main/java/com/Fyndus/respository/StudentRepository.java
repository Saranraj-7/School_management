package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
