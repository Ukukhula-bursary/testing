package com.ukukhula.bursaryapi.services;

import com.ukukhula.bursaryapi.entities.StudentApplication;
import com.ukukhula.bursaryapi.repositories.StudentApplicationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentApplicationService {

    private final StudentApplicationRepository studentApplicationRepository;

    public StudentApplicationService(StudentApplicationRepository studentApplicationRepository) {
        this.studentApplicationRepository = studentApplicationRepository;
    }

    public StudentApplication findByStudentID(int studentID) {
        return studentApplicationRepository.findByStudentID(studentID);
    }

    public List<StudentApplication> getAllStudentsApplications() {
        return studentApplicationRepository.getAllStudentsApplications();
    }
}
