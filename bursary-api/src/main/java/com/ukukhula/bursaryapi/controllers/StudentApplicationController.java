package com.ukukhula.bursaryapi.controllers;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ukukhula.bursaryapi.assemblers.StudentApplicationAssembler;
import com.ukukhula.bursaryapi.entities.StudentApplication;
import com.ukukhula.bursaryapi.services.StudentApplicationService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudentApplicationController {
    private final StudentApplicationService studentApplicationService;
    private final StudentApplicationAssembler assembler;

    public StudentApplicationController(StudentApplicationService studentApplicationService,
            StudentApplicationAssembler assembler) {
        this.studentApplicationService = studentApplicationService;
        this.assembler = assembler;
    }

    @GetMapping("/{studentId}")
    public EntityModel<StudentApplication> getStudentApplications(@PathVariable int studentId) {
        StudentApplication application = studentApplicationService.findByStudentID(studentId);

        // System.out.println(application);
        return assembler.toModel(application);
    }

}