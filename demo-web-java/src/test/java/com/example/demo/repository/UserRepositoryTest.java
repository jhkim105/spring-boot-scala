package com.example.demo.repository;

import com.example.demo.DemoWebJavaApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class UserRepositoryTest extends DemoWebJavaApplicationTests {

  @Autowired
  UserRepository userRepository;

  @Test
  public void findByEmail() throws Exception {
    assertNotNull(userRepository.findByEmail("admin@rsupport.com"));
  }

}