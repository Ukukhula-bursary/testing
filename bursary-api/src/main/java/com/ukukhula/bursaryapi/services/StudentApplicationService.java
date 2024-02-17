package com.ukukhula.bursaryapi.services;

import com.ukukhula.bursaryapi.entities.StudentApplication;
import com.ukukhula.bursaryapi.repositories.StudentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentApplicationService {

    private final StudentApplicationRepository studentApplicationRepository;

    @Autowired
    public StudentApplicationService(StudentApplicationRepository studentApplicationRepository) {
        this.studentApplicationRepository = studentApplicationRepository;
    }

    public StudentApplication findByStudentID(int studentID) {
        return studentApplicationRepository.findByStudentID(studentID);
    }
}
