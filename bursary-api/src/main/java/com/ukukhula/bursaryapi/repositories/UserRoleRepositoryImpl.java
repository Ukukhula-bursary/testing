package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.UserRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository{

    private final JdbcTemplate jdbcTemplate;

    public UserRoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<UserRole> getByRole(String role) {
        String GET_ROLE = "SELECT Role FROM UserRole WHERE Role = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(GET_ROLE, userRoleRowMapper, role));
    }

    private final RowMapper<UserRole> userRoleRowMapper = ((resultSet,
    rowNumber) -> new UserRole(resultSet.getInt("ID"), resultSet.getString(
            "Role")));
}
