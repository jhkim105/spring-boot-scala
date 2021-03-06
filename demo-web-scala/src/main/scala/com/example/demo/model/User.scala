package com.example.demo.model

import java.util.{HashSet, Set}
import javax.persistence._

import com.querydsl.core.annotations.QueryProjection

import scala.beans.BeanProperty

@Table(name = "t_user")
@Entity
class User {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: java.lang.Long = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var username: String = _

  @BeanProperty
  var password: String = _

  @BeanProperty
  var email: String = _

  @ElementCollection(targetClass = classOf[Authority])
  @JoinTable(name = "t_user_authorities", joinColumns = Array(new JoinColumn(name = "user_id")))
  @Column(name = "authority", nullable = false)
  @Enumerated(EnumType.STRING)
  @BeanProperty
  val authorities: Set[Authority] = new HashSet[Authority]()

  @QueryProjection
  def this(id: java.lang.Long, username: String, email: String) = {
    this()
    this.id = id
    this.username = username
    this.email = email
  }

}
