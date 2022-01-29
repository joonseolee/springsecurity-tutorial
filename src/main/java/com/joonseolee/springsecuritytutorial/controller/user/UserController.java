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

    @GetMapping("/users")
    public String createUser() {
        return "/user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto) {
        var newAccountDto = new AccountDto(accountDto.getUsername(),
                passwordEncoder.encode(accountDto.getPassword()),
                accountDto.getEmail(),
                accountDto.getAge(),
                accountDto.getRole());
        var account = accountMapper.toAccount(newAccountDto);
        userService.createUser(account);
        return "redirect:/";
    }
}
