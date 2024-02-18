
package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.University;
import com.ukukhula.bursaryapi.entities.UniversityAllocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityAllocationRepositoryImpl implements UniversityAllocationRepository {
    final String SQL = "SELECT * FROM UniversityAllocation WHERE ID = ?"; 
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UniversityAllocation findById(int id) {
        return jdbcTemplate.queryForObject(SQL, UniversityAllocationRowMapper,
                id);
    }

    @Override
    public List<UniversityAllocation> getAllStudentAllocations() {
        return jdbcTemplate.query("SELECT * FROM UniversityAllocation", UniversityAllocationRowMapper);
    }

    @Override
    public Integer allocateFundsToUniversity(int id, BigDecimal amount) {
        String UPDATE_UNIVERSITY_ALLOCATION = "UPDATE UniversityAllocation SET Amount = ? WHERE ID = ?";
        return jdbcTemplate.update(UPDATE_UNIVERSITY_ALLOCATION, amount, id);
    }

    @Override
    public Integer allocateFundsToAllUniversities() {
        String COUNT_APPROVED_UNIVERSITIES = "SELECT COUNT(Status) FROM UniversityApplication WHERE Status = 'Approved'";
        String SELECT_ADMIN_BALANCE = "SELECT TotalAmount FROM BursaryDetails WHERE Year = YEAR(GETDATE())";
        String UPDATE_ALL_UNIVERSITY_ALLOCATIONS = "UPDATE UniversityAllocation " +
                "SET Amount = ? " +
                "WHERE UniversityID IN ( " +
                "    SELECT ua.UniversityID " +
                "    FROM UniversityApplication ua " +
                "    WHERE ua.Status = 'Approved' " +
                ")";

        Integer numberOfApprovedUniversities = jdbcTemplate.queryForObject(COUNT_APPROVED_UNIVERSITIES, Integer.class);
        BigDecimal availableBalance = jdbcTemplate.queryForObject(SELECT_ADMIN_BALANCE, BigDecimal.class);

        BigDecimal amountPerUniversity = availableBalance.divide(BigDecimal.valueOf(numberOfApprovedUniversities), 4,
                RoundingMode.HALF_UP);

        return jdbcTemplate.update(UPDATE_ALL_UNIVERSITY_ALLOCATIONS, amountPerUniversity);

    }

    private final RowMapper<UniversityAllocation> UniversityAllocationRowMapper = ((resultSet,
            rowNumber) -> {
        return new UniversityAllocation(resultSet.getInt("ID"), resultSet.getInt("UniversityID"),
                resultSet.getBigDecimal("Amount"), resultSet.getInt("BursaryDetailsID"));
    });

}
