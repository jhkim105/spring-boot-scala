package com.example.demo.repository

import java.util
import javax.persistence.{EntityManager, PersistenceContext}

import com.example.demo.model.{QUser, User, UsernameEmail}
import com.querydsl.jpa.impl.JPAQuery
import org.slf4j.LoggerFactory

class UserRepositoryImpl extends UserRepositoryCustom {

  var log = LoggerFactory.getLogger(classOf[UserRepositoryImpl])

  @PersistenceContext private val entityManager: EntityManager = null

  override def findActiveUsers(): util.ArrayList[UsernameEmail] = {
    def query = new JPAQuery[User](entityManager)

    val user = QUser as "user"
    query.from(user)
    val list = query.from(user).select(user.id, user.username, user.email).fetch()
    val result = new util.ArrayList[UsernameEmail];
    list.forEach(data => result.add(UsernameEmail(data.get(user.id), data.get(user.username), data.get(user.email))))
    result
  }

}
