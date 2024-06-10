package com.Fyndus.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Fyndus.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);

	@Query(value = "SELECT s.* FROM Student s " + "JOIN School sch ON s.school_id = sch.id "
			+ "WHERE (:name IS NULL OR s.name = :name) " + "AND (:id IS NULL OR s.id = :id) "
			+ "AND (:schoolId IS NULL OR sch.id = :schoolId) " + "AND (:schoolName IS NULL OR sch.name = :schoolName) "
			+ "ORDER BY s.id DESC", nativeQuery = true)
	List<Student> searchByCriteria(@Param("name") String name, @Param("id") Long id, @Param("schoolId") Long schoolId,
			@Param("schoolName") String schoolName);
}
