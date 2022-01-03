package com.joonseolee.springsecuritytutorial.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SecurityController {

    @GetMapping
    public String index(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 인증된 이후에는 세션에도 저장이 됨 (확인가능)
        SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        return "home";
    }

    @GetMapping("/thread")
    public String thread() {
        new Thread(() -> {
            // 기본전략때문에 다른 쓰레드에서는 확인할수없음.
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                }
        ).start();

        return "thread";
    }

    @GetMapping("loginPage")
    public String loginPage() {
        return "loginPage";
    }
}
