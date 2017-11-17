package com.example.demo.security

import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService, UsernameNotFoundException}
import org.springframework.transaction.annotation.Transactional

class CustomUserDetailsService  extends UserDetailsService {
  @Autowired var userRepository: UserRepository = null
  @Transactional(readOnly = true)
  @throws[UsernameNotFoundException]
  override def loadUserByUsername(username: String): UserDetails = {
    val user = userRepository.findByUsername(username)
    new CustomUserDetails(user)
  }
}
