package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Fyndus.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

	List<School> searchByName(String name);

	@Query(value = "SELECT * FROM School WHERE name = ?1 AND id = ?2", nativeQuery = true)
	List<School> searchByNameAndId(String name, Long id);

	@Query(value = "SELECT * FROM School WHERE id = ?1", nativeQuery = true)
	List<School> searchById(Long id);

}
