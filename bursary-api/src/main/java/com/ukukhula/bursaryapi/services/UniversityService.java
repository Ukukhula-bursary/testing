package com.ukukhula.bursaryapi.services;

import com.ukukhula.bursaryapi.entities.University;

public interface UniversityService {
  University addUniversity(String name);

  University getUniversityById(int id);
}
