package com.example.demowebjava.repository;

import com.example.demowebjava.DemoWebJavaApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class UserRepositoryTest extends DemoWebJavaApplicationTests {

  @Autowired
  UserRepository userRepository;

  @Test
  public void findByEmail() throws Exception {
    assertNotNull(userRepository.findByEmail("admin@rsupport.com"));
  }

}