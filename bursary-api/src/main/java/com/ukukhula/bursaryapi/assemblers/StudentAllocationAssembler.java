package com.ukukhula.bursaryapi.assemblers;

import com.ukukhula.bursaryapi.controllers.StudentAllocationController;
import com.ukukhula.bursaryapi.entities.StudentAllocation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class StudentAllocationAssembler implements RepresentationModelAssembler<StudentAllocation, EntityModel<StudentAllocation>> {

    @Override
    public EntityModel<StudentAllocation> toModel(StudentAllocation studentAllocation) {
        return EntityModel.of(studentAllocation,
                linkTo(methodOn(StudentAllocationController.class).getStudentAllocationById(studentAllocation.getId())).withSelfRel(),
                linkTo(methodOn(StudentAllocationController.class).getAllStudentAllocations()).withRel("allStudentAllocations"),
                // Add more links as needed
                linkTo(methodOn(StudentAllocationController.class).getTotalSpentByUniversity(0, 0)).withRel("totalSpentByUniversity"));
    }
}
