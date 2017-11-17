package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
trait UserRepository extends JpaRepository[User, java.lang.Long] {
  def findByUsername(username: String): User
}
