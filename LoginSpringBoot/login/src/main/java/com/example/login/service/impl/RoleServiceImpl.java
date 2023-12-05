package com.example.login.service.impl;

import com.example.login.model.Role;
import com.example.login.model.RoleName;
import com.example.login.reporsitory.IRoleRepository;
import com.example.login.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
