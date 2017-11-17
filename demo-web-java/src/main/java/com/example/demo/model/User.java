package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter @Setter @ToString
public class User {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String username;

  private String password;

  private String email;

  @ElementCollection(targetClass = Authority.class)
  @JoinTable(name = "t_user_authorities", joinColumns = { @JoinColumn(name = "user_id") })
  @Column(name = "authority", nullable = false)
  @Enumerated(EnumType.STRING)
  private Set<Authority> authorities = new HashSet<>();

}
