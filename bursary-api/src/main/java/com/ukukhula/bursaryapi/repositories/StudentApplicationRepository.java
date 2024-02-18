package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.ApplicationStatus;
import com.ukukhula.bursaryapi.entities.StudentApplication;

import java.util.List;

public interface StudentApplicationRepository {
    StudentApplication findByStudentID(int studentID);

    List<StudentApplication> getAllStudentsApplications();

    Integer updateStudentsApplicationStatus(int studentID, String status);
}
