package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

  @GetMapping(Array("/login"))
  def loginForm = "login"
}
