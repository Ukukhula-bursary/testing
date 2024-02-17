package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.University;

public interface UniversityRepository {

  Integer addUniversity(String name);

  University getUniversityById(int id);
}