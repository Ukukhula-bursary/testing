package com.ukukhula.bursaryapi.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.ukukhula.bursaryapi.controllers.UniversityController;
import com.ukukhula.bursaryapi.entities.University;

@Component
public class UniversityModelAssembler implements RepresentationModelAssembler<University, EntityModel<University>> {

  @Override
  public EntityModel<University> toModel(University university) {
    return EntityModel.of(university,
        linkTo(methodOn(UniversityController.class).one(university.getId())).withSelfRel());
  }

}
