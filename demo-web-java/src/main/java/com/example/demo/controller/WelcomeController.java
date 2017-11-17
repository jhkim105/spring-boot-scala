package com.example.demo.controller;

import com.example.demo.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class WelcomeController {

  @GetMapping("/")
  public String welcome(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
    String message = "Hello Spring With Java";
    log.debug("customUserDetails:{}" + customUserDetails);
    model.addAttribute("message", message);
    model.addAttribute("currentUserDetail", customUserDetails);
    return "welcome";
  }

}
