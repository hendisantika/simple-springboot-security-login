package com.hendisantika.simplespringbootsecuritylogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : simple-springboot-security-login
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-23
 * Time: 05:06
 */
@Controller
public class HomeController {
    Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    String index() {
        log.info("Calling Index");
        return "index";
    }
}
