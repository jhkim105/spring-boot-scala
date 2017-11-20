package com.example.demo.repository

import java.util

import com.example.demo.model.{User, UsernameEmail}

trait UserRepositoryCustom {

  def findActiveUsers(): util.ArrayList[UsernameEmail]


}
