package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.StudentApplication;

import java.util.List;

public interface StudentApplicationRepository {
    StudentApplication findByStudentID(int studentID);

    List<StudentApplication> getAllStudentsApplications();
}
