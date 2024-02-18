package com.ukukhula.bursaryapi.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.ukukhula.bursaryapi.entities.University;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class UniversityRepoImpl implements UniversityRepository {

  private static final String INSERT_UNIVERSITY = "INSERT INTO University (Name) VALUES (?)";
  private static final String GET_UNIVERSITY_BY_ID = "EXEC [dbo].[uspGetUniversityById] ?";
  private static final String GET_ALL_UNIVERSITIES = "SELECT * FROM University";

  final
  JdbcTemplate jdbcTemplate;

  public UniversityRepoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

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

      return Objects.requireNonNull(keyHolder.getKey()).intValue();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public University getUniversityById(int id) {
    return jdbcTemplate.queryForObject(GET_UNIVERSITY_BY_ID, universityRowMapper,
        id);
  }

  @Override
  public List<University> getAllUniversities() {
    return jdbcTemplate.query(GET_ALL_UNIVERSITIES, universityRowMapper);
  }

  private final RowMapper<University> universityRowMapper = ((resultSet,
      rowNumber) -> new University(resultSet.getInt("ID"), resultSet.getString("Name")));
}
