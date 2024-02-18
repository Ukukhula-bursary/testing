package com.ukukhula.bursaryapi.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ukukhula.bursaryapi.ApplicationStatus;
import com.ukukhula.bursaryapi.assemblers.StudentApplicationAssembler;
import com.ukukhula.bursaryapi.entities.StudentApplication;
import com.ukukhula.bursaryapi.services.StudentApplicationService;

@RestController
public class StudentApplicationController {
    private final StudentApplicationService studentApplicationService;
    private final StudentApplicationAssembler assembler;

    public StudentApplicationController(StudentApplicationService studentApplicationService,
            StudentApplicationAssembler assembler) {
        this.studentApplicationService = studentApplicationService;
        this.assembler = assembler;
    }

    @GetMapping("/student/{studentId}")
    public EntityModel<StudentApplication> getStudentApplications(@PathVariable int studentId) {
        StudentApplication application = studentApplicationService.findByStudentID(studentId);
        return assembler.toModel(application);
    }

    @GetMapping("/students")
    public CollectionModel<EntityModel<StudentApplication>> getAllStudentApplications() {
        List<EntityModel<StudentApplication>> applications = studentApplicationService.getAllStudentsApplications()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(applications);
    }

    @PutMapping("/status/{studentID}")
    public ResponseEntity<?> updateStudentsApplicationStatus(@PathVariable int studentID,
            @RequestBody Map<String, String> requestBody) {
        String statusString = requestBody.get("status");

        try {
 
            Integer rowsAffected = studentApplicationService.updateStudentsApplicationStatus(studentID, statusString);

            if (rowsAffected >= 1) {
                return ResponseEntity.ok("Student status successful");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid status value");
        }

    }
}