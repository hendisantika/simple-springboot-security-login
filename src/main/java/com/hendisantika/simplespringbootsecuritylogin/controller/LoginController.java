package com.hendisantika.simplespringbootsecuritylogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : simple-springboot-security-login
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-23
 * Time: 05:07
 */
@Controller
public class LoginController {
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    ModelAndView login(@RequestParam Optional<String> error) {
        log.info("Calling login");
        ModelAndView modelAndView = new ModelAndView("login/login");
        if (error.isPresent()) {
            modelAndView.addObject("error", "Invalid Credentials");
        }
        return modelAndView;
    }
}
