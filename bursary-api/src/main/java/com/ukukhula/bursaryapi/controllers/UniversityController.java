package com.ukukhula.bursaryapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ukukhula.bursaryapi.assemblers.UniversityModelAssembler;
import com.ukukhula.bursaryapi.entities.University;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ukukhula.bursaryapi.services.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UniversityController {

  private UniversityService universityService;

  private final UniversityModelAssembler assembler;

  UniversityController(UniversityModelAssembler assembler, UniversityService universityService) {
    this.assembler = assembler;
    this.universityService = universityService;
  }

  @PostMapping("/universities")
  public ResponseEntity<?> newUniversity(@RequestBody University newUniversity) {
    EntityModel<University> entityModel = assembler.toModel(universityService.addUniversity(newUniversity.getName()));

    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @GetMapping("/universities/{id}")
  public EntityModel<University> one(@PathVariable int id) {

    University university = universityService.getUniversityById(id);
    return assembler.toModel(university);
  }
}
