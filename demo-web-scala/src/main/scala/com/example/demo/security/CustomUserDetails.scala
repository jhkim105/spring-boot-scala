package com.example.demo.security

import com.example.demo.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import scala.beans.BeanProperty

class CustomUserDetails(user: User) extends UserDetails{

  var id: Long = _

  @BeanProperty
  var username: String = _

  @BeanProperty
  var password: String = _

  @BeanProperty
  var authorities: java.util.Collection[GrantedAuthority] = new java.util.HashSet[GrantedAuthority]()

  id = user.getId()
  username = user.getName()
  password = user.getPassword()
  user.getAuthorities().stream().forEach(o => authorities.add(new GrantedAuthority {
    override def getAuthority: String = o.name()
  }))

  override def isAccountNonExpired = true

  override def isAccountNonLocked = true

  override def isCredentialsNonExpired = true

  override def isEnabled = true

}
