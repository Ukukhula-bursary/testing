package com.ukukhula.bursaryapi.controllers;

import com.ukukhula.bursaryapi.assemblers.UniversityAllocationAssembler;
import com.ukukhula.bursaryapi.entities.UniversityAllocation;
import com.ukukhula.bursaryapi.services.UniversityAllocationService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allocations")
public class UniversityAllocationController {
    @Autowired
    private UniversityAllocationService universityAllocationService;
    private UniversityAllocationAssembler universityAssembler;

    UniversityAllocationController(UniversityAllocationAssembler universityAssembler,UniversityAllocationService universityAllocationService){
        this.universityAssembler = universityAssembler;
        this.universityAllocationService = universityAllocationService;
    }
    // Endpoint to retrieve a UniversityAllocation by its ID
    @GetMapping("/{id}")
    public EntityModel<UniversityAllocation> getUniversityAllocationById(@PathVariable int id) {
        // Call service layer to find the UniversityAllocation by ID
        UniversityAllocation universityAllocation = universityAllocationService.findUniversityAllocationById(id);
        
        return universityAssembler.toModel(universityAllocation);
    }

    // @GetMapping("/")
    // public CollectionModel<EntityModel<UniversityAllocation>> getAllUniversityAllocations() {
    //     // Call service layer to find the UniversityAllocation by ID
    //     <List<EntityModel<UniversityAllocation>> allAllocations = UniversityAllocationService.getAllAllocations().stream().map(universityAssembler::toModel).collect(Collectors.toList());

        
    //     return CollectionModel.of(allAllocations,linkTo(methodOn(UniversityAllocationController.class).getAllUniversityAllocations()).withSelfRel())
    // }
}