package com.joonseolee.springsecuritytutorial.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountDto {

    private String username;
    private String password;
    private String email;
    private int age2;
    private String role;

    @Default
    public AccountDto(String username, String password, String email, int age2, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age2 = age2;
        this.role = role;
    }
}
