package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.UniversityAllocation;

public interface UniversityAllocationRepository {
    UniversityAllocation findById(int id);
}