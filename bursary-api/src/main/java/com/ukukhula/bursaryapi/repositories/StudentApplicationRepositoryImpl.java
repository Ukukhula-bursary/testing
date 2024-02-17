package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.StudentApplication;
import com.ukukhula.bursaryapi.entities.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentApplicationRepositoryImpl implements StudentApplicationRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public StudentApplicationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<StudentApplication> studentRowMapper = ((resultSet,
            rowNumber) -> {
        return new StudentApplication(resultSet.getInt("ID"),
                resultSet.getInt("StudentID"),
                resultSet.getString("Motivation"),
                resultSet.getBigDecimal("BursaryAmount"),
                resultSet.getString("Status"),
                resultSet.getString("RejectionReason"),
                resultSet.getDate("Date")
        );
    });

    @Override
    public StudentApplication findByStudentID(int studentID) {
        String sql = "SELECT * FROM StudentApplication WHERE StudentID = ?";

        StudentApplication students = jdbcTemplate.queryForObject(sql, studentRowMapper, studentID);

        return students;
    }
}
