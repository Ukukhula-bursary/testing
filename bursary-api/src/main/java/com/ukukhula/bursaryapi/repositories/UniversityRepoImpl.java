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
  private static final String GET_INIVERSITY_BY_ID = "EXEC [dbo].[uspGetUniversityById] ?";

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public Integer addUniversity(String name) {
    try {
      KeyHolder keyHolder = new GeneratedKeyHolder();

      jdbcTemplate.update(
          connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_UNIVERSITY,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);

            return ps;
          }, keyHolder);

      return keyHolder.getKey().intValue();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public University getUniversityById(int id) {
    return jdbcTemplate.queryForObject(GET_INIVERSITY_BY_ID, universityRowMapper,
        id);
  }

  private final RowMapper<University> universityRowMapper = ((resultSet,
      rowNumber) -> {
    return new University(resultSet.getInt("ID"), resultSet.getString("Name"));
  });
}
