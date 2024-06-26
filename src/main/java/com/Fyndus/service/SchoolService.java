package com.Fyndus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Fyndus.entity.School;
import com.Fyndus.respository.SchoolRepository;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> retriveSchool() {
        return schoolRepository.findAll();
    }

    public Page<School> retrieveSchoolPage(Pageable pageable) {
        return schoolRepository.findAll(pageable);
    }

    public List<School> searchSchools(String name, Long id) {
        return schoolRepository.search(name, id);
    }
}
