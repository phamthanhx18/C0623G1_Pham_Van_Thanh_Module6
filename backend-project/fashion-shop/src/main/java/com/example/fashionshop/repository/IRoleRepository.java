package com.example.fashionshop.repository;

import com.example.fashionshop.model.Role;
import com.example.fashionshop.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}
