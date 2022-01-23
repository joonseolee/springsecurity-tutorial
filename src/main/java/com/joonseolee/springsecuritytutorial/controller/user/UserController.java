package com.joonseolee.springsecuritytutorial.controller.user;

import com.joonseolee.springsecuritytutorial.domain.AccountDto;
import com.joonseolee.springsecuritytutorial.domain.AccountMapper;
import com.joonseolee.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AccountMapper accountMapper;

    @GetMapping("/mypage")
    public String myPage() {
        return "/user/mypage";
    }

    @GetMapping("/accounts")
    public String createUser() {
        return "/user/login/register";
    }

    @PostMapping("/accounts")
    public String createUser(AccountDto accountDto) {
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        var account = accountMapper.toAccount(accountDto);
        userService.createUser(account);
        return "redirect:/";
    }
}
