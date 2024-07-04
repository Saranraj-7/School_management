package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Fyndus.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

	@Query("SELECT s FROM School s WHERE " + 
           "LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR LOWER(s.address) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "OR CAST(s.id AS string) LIKE CONCAT('%', :search, '%')")
	List<School> searchSchools(String search);

	List<School> findByName(String name);
}
