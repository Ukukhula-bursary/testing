package com.ukukhula.bursaryapi.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.ukukhula.bursaryapi.controllers.StudentApplicationController;
import com.ukukhula.bursaryapi.entities.StudentApplication;

@Component
public class StudentApplicationAssembler
        implements RepresentationModelAssembler<StudentApplication, EntityModel<StudentApplication>> {

    @Override
    public EntityModel<StudentApplication> toModel(StudentApplication studentApplication) {
        return EntityModel.of(studentApplication,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentApplicationController.class)
                        .getStudentApplications(studentApplication.getStudentID())).withSelfRel()
                // linkTo(methodOn(StudentApplicationController.class).getAllStudentApplications())
                //         .withRel("allstudentapplications")
                );
    }
}
