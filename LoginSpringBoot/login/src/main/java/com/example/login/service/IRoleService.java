package com.example.login.service;

import com.example.login.model.Role;
import com.example.login.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
