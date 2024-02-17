
package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.University;
import com.ukukhula.bursaryapi.entities.UniversityAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityAllocationRepositoryImpl implements UniversityAllocationRepository {
    final String SQL = "SELECT * FROM UniversityAllocation WHERE ID = ?"; // procedure
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UniversityAllocation findById(int id) {
        return jdbcTemplate.queryForObject(SQL, UniversityAllocationRowMapper,
                id);
    }

    private final RowMapper<UniversityAllocation> UniversityAllocationRowMapper = ((resultSet,
            rowNumber) -> {
        return new UniversityAllocation(resultSet.getInt("ID"), resultSet.getInt("UniversityID"),
                resultSet.getBigDecimal("Amount"), resultSet.getInt("BursaryDetailsID"));
    });

    // ADD SERVICES - class or interface and implementation??

}
