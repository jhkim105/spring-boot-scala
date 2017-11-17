package com.example.demo.repository;

import com.example.demo.model.User;

public interface UserRepositoryCustom {
  User findByEmail(String email);
}
