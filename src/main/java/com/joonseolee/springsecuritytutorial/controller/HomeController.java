package com.joonseolee.springsecuritytutorial.controller;

import com.joonseolee.springsecuritytutorial.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ApplicationContext applicationContext;

    @GetMapping(value="/")
    public String home() throws Exception {
        return "home";
    }

    @GetMapping("/test")
    @ResponseBody
    public Object dfadsf() {
        var account = new Account();
        account.setUsername("helelo");
        return account;
    }
}
