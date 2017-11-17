package com.example.demo.security;

import com.example.demo.model.Authority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public CustomUserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/resources/**", "/storage/**").permitAll()
          .antMatchers("/").hasAnyAuthority(Authority.ADMIN.name(), Authority.USER.name())
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll().and()
        .csrf().disable();
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
