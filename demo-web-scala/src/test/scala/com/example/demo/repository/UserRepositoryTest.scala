package com.example.demo.repository

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryTest extends AbstractTest {

  @Autowired
  var userRepository:UserRepository = null

  @Test
  def findActiveUsers() = {
   val list = userRepository.findActiveUsers()
  log.debug("{}", list)
  }

}
