package com.ukukhula.bursaryapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ukukhula.bursaryapi.entities.University;
import com.ukukhula.bursaryapi.repositories.UniversityRepository;

@Service
@Transactional
public class UniversityServiceImpl implements UniversityService {
  @Autowired
  UniversityRepository universityRepository;

  @Override
  public University addUniversity(String name) {
    Integer id = universityRepository.addUniversity(name);
    return universityRepository.getUniversityById(id);
  }

  @Override
  public University getUniversityById(int id) {
    return universityRepository.getUniversityById(id);
  }

  @Override
  public List<University> getAllUniversities() {
    return universityRepository.getAllUniversities();
  }
}
