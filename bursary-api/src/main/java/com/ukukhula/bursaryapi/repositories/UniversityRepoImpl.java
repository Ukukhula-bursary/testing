package com.ukukhula.bursaryapi.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ukukhula.bursaryapi.entities.University;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class UniversityRepoImpl implements UniversityRepository {

  private static final String INSERT_UNIVERSITY = "INSERT INTO University (Name) VALUES (?)";

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public Integer addUniversity(String name) {
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(
        connection -> {
          PreparedStatement ps = connection.prepareStatement(INSERT_UNIVERSITY,
              Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, name);
          return ps;
        },
        keyHolder);

    return (Integer) keyHolder.getKey();
  }

}
