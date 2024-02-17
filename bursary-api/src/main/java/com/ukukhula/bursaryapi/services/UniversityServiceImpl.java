package com.ukukhula.bursaryapi.services;

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
  public University getUniversityById(int id) {
    return universityRepository.getUniversityById(id);
  }
}
