package com.example.demowebjava.repository;

import com.example.demowebjava.model.User;

public interface UserRepositoryCustom {
  User findByEmail(String email);
}
