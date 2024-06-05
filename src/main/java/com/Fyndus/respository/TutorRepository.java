package com.Fyndus.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Fyndus.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

	List<Tutor> searchByName(String name);

	@Query(value = "SELECT * FROM Tutor WHERE id = ?1", nativeQuery = true)
	List<Tutor> searchById(long id);

	@Query(value = "SELECT * FROM Tutor WHERE id = ?1 AND name = ?2", nativeQuery = true)
	List<Tutor> searchByTutorNameAndId(String name, long id);

}
