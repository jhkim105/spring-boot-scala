package com.example.demowebjava.repository;

import com.example.demowebjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

  User findByUsername(String username);

}
