package com.ukukhula.bursaryapi.repositories;

import java.util.List;

import com.ukukhula.bursaryapi.entities.UniversityAllocation;

public interface UniversityAllocationRepository {
    UniversityAllocation findById(int id);
   List<UniversityAllocation> getAllStudentAllocations();
}