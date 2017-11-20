package com.example.demo.model

trait View
case class UsernameEmail(id:Long, username: String, email:String) extends  View {
  def this(u: User) = this(u.id, u.username, u.email)
  def this() = this(new User())
}
