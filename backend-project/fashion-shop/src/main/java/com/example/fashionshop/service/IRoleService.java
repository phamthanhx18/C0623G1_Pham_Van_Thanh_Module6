package com.example.fashionshop.service;

import com.example.fashionshop.model.Role;
import com.example.fashionshop.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
