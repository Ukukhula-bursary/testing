package com.ukukhula.bursaryapi.repositories;

import com.ukukhula.bursaryapi.entities.UserRole;

import java.util.Optional;

public interface UserRoleRepository {
    Optional<UserRole> getByRole(String role);
}
