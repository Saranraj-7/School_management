package com.Fyndus.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

}
