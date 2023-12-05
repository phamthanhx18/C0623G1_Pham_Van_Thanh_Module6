package com.example.login.reporsitory;

import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    // Tìm user trong DB
    Optional<User> findByUsername(String name);
   // Kiem tra xem username có ton tai trong DB khong
    Boolean existsByUsername(String username);
    // Kiem tra xem email co ton tai trong DB khong
    Boolean existsByEmail(String email);
}
