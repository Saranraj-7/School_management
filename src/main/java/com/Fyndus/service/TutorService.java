package com.Fyndus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fyndus.entity.Tutor;
import com.Fyndus.exception.ErrorHandler;
import com.Fyndus.respository.TutorRepository;

@Service
public class TutorService {

	@Autowired
	TutorRepository tutorRepository;

	public Tutor createTutor(Tutor tutor) {
		List<Tutor> existingTutors = tutorRepository.findByName(tutor.getName());
		if(!existingTutors.isEmpty()) {
			throw new ErrorHandler("Tutor is Already in This School");
		}
		return tutorRepository.save(tutor);
	}

	public List<Tutor> retriveTutor() {
		return tutorRepository.findAll();
	}

	public Optional<Tutor> tutorById(long id) {
		return tutorRepository.findById(id);
	}

	public List<Tutor> searchByName(String name) {
		return tutorRepository.searchByName(name);
	}

	public List<Tutor> searchById(long id) {
		return tutorRepository.searchById(id);
	}

	public List<Tutor> searchByTutorNameAndId(String name, long id) {
		return tutorRepository.searchByTutorNameAndId(name, id);
	}

	public List<Tutor> getAllStaff() {
		return tutorRepository.findAll();
	}
}
