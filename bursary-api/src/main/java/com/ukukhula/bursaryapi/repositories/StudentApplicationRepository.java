package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.StudentApplication;

public interface StudentApplicationRepository {
    StudentApplication findByStudentId(Integer id);
}
