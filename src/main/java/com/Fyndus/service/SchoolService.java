package com.Fyndus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Fyndus.entity.School;
import com.Fyndus.exception.ErrorHandler;
import com.Fyndus.exception.NoRecordsFoundException;
import com.Fyndus.respository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	public School createSchool(School school) {
		List<School> existingSchools = schoolRepository.findByName(school.getName());
		if (!existingSchools.isEmpty()) {
			throw new ErrorHandler("School with this name already exists");
		}
		return schoolRepository.save(school);
	}

	public List<School> retriveSchool() {
		return schoolRepository.findAll();
	}

	public Page<School> retrieveSchoolPage(Pageable pageable) {
		return schoolRepository.findAll(pageable);
	}

	public List<School> searchSchools(String search) {
		List<School> schools = schoolRepository.searchSchools(search);
		if (schools.isEmpty()) {
			throw new NoRecordsFoundException("No records found ");
		}
		return schools;
	}
}
