package com.ukukhula.bursaryapi.controllers;

import com.ukukhula.bursaryapi.entities.UniversityAllocation;
import com.ukukhula.bursaryapi.services.UniversityAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allocations")
public class UniversityAllocationController {
    @Autowired
    UniversityAllocationService universityAllocationService;


    // Endpoint to retrieve a UniversityAllocation by its ID
    @GetMapping("/{id}")
    public ResponseEntity<UniversityAllocation> getUniversityAllocationById(@PathVariable int id) {
        // Call service layer to find the UniversityAllocation by ID
        UniversityAllocation universityAllocation = universityAllocationService.findUniversityAllocationById(id);
        
        return ResponseEntity.ok(universityAllocation);
    }
}