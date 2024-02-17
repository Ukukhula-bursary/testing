package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.StudentApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentApplicationRepositoryImpl implements StudentApplicationRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public StudentApplicationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StudentApplication findByStudentID(int studentID) {
        String sql = "SELECT * FROM StudentApplication WHERE StudentID = ?";

        BeanPropertyRowMapper<StudentApplication> studentRowMapper = new BeanPropertyRowMapper<>(
                StudentApplication.class);

        StudentApplication students = jdbcTemplate.queryForObject(sql, studentRowMapper, studentID);

        return students;
    }
}
