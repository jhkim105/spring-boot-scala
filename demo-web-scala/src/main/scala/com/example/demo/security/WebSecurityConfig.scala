package com.example.demo.security

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.{NoOpPasswordEncoder, PasswordEncoder}

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  override def userDetailsService = new CustomUserDetailsService()

  @throws[Exception]
  override protected def configure(http: HttpSecurity): Unit = {
    http.csrf().disable()
      .formLogin().loginPage("/login").permitAll().and()
      .authorizeRequests.antMatchers("/resources/**", "/storage/**", "/login").permitAll
      .antMatchers("/api/**").hasAuthority("USER")
      .antMatchers("/admin/**").hasAuthority("ADMIN")
      .anyRequest.authenticated()
  }

  @Bean
  def passwordEncoder: PasswordEncoder = NoOpPasswordEncoder.getInstance
}
