package com.example.demo.controller

import com.example.demo.security.CustomUserDetails
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WelcomeController {

  val log: Logger = LoggerFactory.getLogger(this.getClass);

  @GetMapping(Array("/"))
  def welcome(model: Model, @AuthenticationPrincipal customUserDetails: CustomUserDetails): String = {
    val message = "Hello Spring With Java"
    log.debug("customUserDetails:{}", customUserDetails)
    model.addAttribute("message", message)
    model.addAttribute("currentUserDetail", customUserDetails)
    "welcome"
  }

}
