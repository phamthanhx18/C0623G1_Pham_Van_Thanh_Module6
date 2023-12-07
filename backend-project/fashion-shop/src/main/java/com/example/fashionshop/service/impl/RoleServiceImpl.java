package com.example.fashionshop.service.impl;

import com.example.fashionshop.model.Role;
import com.example.fashionshop.model.RoleName;
import com.example.fashionshop.repository.IRoleRepository;
import com.example.fashionshop.service.IRoleService;
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
