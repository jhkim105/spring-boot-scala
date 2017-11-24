package com.example.demo.repository;

import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

  @Override
  public List<User> findActiveUsers() {
    QUser user = QUser.user;
    JPAQuery<User> query = new JPAQuery<>(entityManager);
    return query.from(user).select(QUser.create(user.id, user.username, user.email)).fetch();
  }
}
