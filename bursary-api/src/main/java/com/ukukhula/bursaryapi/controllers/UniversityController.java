package com.ukukhula.bursaryapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ukukhula.bursaryapi.entities.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import com.ukukhula.bursaryapi.services.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UniversityController {

  @Autowired
  private UniversityService universityService;

  @GetMapping("/universities/{id}")
  EntityModel<University> oneUniversity(@PathVariable int id) {

    University university = universityService.getUniversityById(id);
    return EntityModel.of(university,
        linkTo(methodOn(UniversityController.class).oneUniversity(id)).withSelfRel());
  }
}
