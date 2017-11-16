package com.example.demowebjava.security;

import com.example.demowebjava.model.User;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class CustomUserDetails implements UserDetails {
 private Long id;
 private String username;
 private String password;
 private Set<GrantedAuthority> authorities;

 public CustomUserDetails(User user) {
   this.id = user.getId();
   this.username = user.getUsername();
   this.password = user.getPassword();
   authorities = new HashSet<>();
   user.getAuthorities().stream().forEach(authority -> authorities.add((GrantedAuthority) authority::name));
 }

 @Override public boolean isAccountNonExpired() { return true; }
 @Override public boolean isAccountNonLocked() { return true; }
 @Override public boolean isCredentialsNonExpired() { return true; }
 @Override public boolean isEnabled() { return true; }
}
