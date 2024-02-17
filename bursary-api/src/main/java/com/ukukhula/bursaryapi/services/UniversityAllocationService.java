package com.ukukhula.bursaryapi.services;

import com.ukukhula.bursaryapi.entities.University;
import com.ukukhula.bursaryapi.entities.UniversityAllocation;
import com.ukukhula.bursaryapi.repositories.UniversityAllocationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityAllocationService {
    @Autowired
    private final UniversityAllocationRepository universityAllocationRepository;

    public UniversityAllocationService(UniversityAllocationRepository universityAllocationRepository) {
        this.universityAllocationRepository = universityAllocationRepository;
    }

      //  call to the repository to fetch UniversityAllocation by ID
    public UniversityAllocation findUniversityAllocationById(int id) {
        return universityAllocationRepository.findById(id);
    }

    
    public List<UniversityAllocation> getAllAllocations() {
        return universityAllocationRepository.getAllStudentAllocations();
      }

    
}