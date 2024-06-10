package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Fyndus.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

	@Query(value = "SELECT * FROM School WHERE (:name is null or name = :name) AND (:id is null or id = :id)", nativeQuery = true)
	List<School> search(String name, Long id);

}
