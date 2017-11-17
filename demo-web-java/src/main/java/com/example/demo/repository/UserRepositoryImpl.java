package com.example.demowebjava.repository;

import com.example.demowebjava.model.QUser;
import com.example.demowebjava.model.User;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User findByEmail(String email) {
    QUser user = QUser.user;

    JPAQuery<User> query = new JPAQuery<>(entityManager);
    query.from(user).where(user.email.eq(email));

    return query.fetchOne();
  }
}