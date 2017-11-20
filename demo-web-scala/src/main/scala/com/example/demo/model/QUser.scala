package com.example.demo.model

import com.querydsl.core.types._
import com.querydsl.scala._

import com.querydsl.core.types.PathMetadataFactory._;

object QUser extends QUser("user") {
  override def as(variable: String) = new QUser(variable)
  
}

class QUser(cl: Class[_ <: User], md: PathMetadata) extends EntityPathImpl[User](cl, md) {
  def this(variable: String) = this(classOf[User], forVariable(variable))

  def this(parent: Path[_], variable: String) = this(classOf[User], forProperty(parent, variable))

  val authorities = createSet[Authority,EnumPath[Authority]]("authorities")

  val email = createString("email")

  val id = createNumber[Long]("id")

  val name = createString("name")

  val password = createString("password")

  val username = createString("username")

}

