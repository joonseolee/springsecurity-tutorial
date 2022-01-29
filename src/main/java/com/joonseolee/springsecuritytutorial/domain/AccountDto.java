package com.joonseolee.springsecuritytutorial.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private String username;
    private String password;
    private String email;
    private int age;
    private String role;

    public AccountDto() {}

    @Default
    public AccountDto(String username, String password, String email, int age, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.role = role;
    }
}
