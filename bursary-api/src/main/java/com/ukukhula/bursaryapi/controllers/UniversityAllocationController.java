package com.ukukhula.bursaryapi.controllers;

import com.ukukhula.bursaryapi.assemblers.UniversityAllocationAssembler;
import com.ukukhula.bursaryapi.entities.UniversityAllocation;
import com.ukukhula.bursaryapi.services.UniversityAllocationService;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/allocations")
public class UniversityAllocationController {
    @Autowired
    private UniversityAllocationService universityAllocationService;
    private UniversityAllocationAssembler universityAssembler;

    UniversityAllocationController(UniversityAllocationAssembler universityAssembler,
            UniversityAllocationService universityAllocationService) {
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

    @PutMapping("/allocate/{id}")
    public ResponseEntity<String> allocateFundsToUniversity(@PathVariable int id,
            @RequestBody Map<String, BigDecimal> amount) {
        BigDecimal allocatedAmount = amount.get("amount");
        System.out.print(allocatedAmount);
        Integer updatedRows = universityAllocationService.allocateFundsToUniversity(id, allocatedAmount);
        if (updatedRows > 0) {
            return ResponseEntity.ok("Funds allocated successfully to the university.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to allocate funds.");
        }
    }

 
    // @GetMapping("/")
    // public CollectionModel<EntityModel<UniversityAllocation>>
    // getAllUniversityAllocations() {
    // // Call service layer to find the UniversityAllocation by ID
    // <List<EntityModel<UniversityAllocation>> allAllocations =
    // UniversityAllocationService.getAllAllocations().stream().map(universityAssembler::toModel).collect(Collectors.toList());

    // return
    // CollectionModel.of(allAllocations,linkTo(methodOn(UniversityAllocationController.class).getAllUniversityAllocations()).withSelfRel())
    // }
}