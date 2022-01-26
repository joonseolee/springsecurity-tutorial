package com.joonseolee.springsecuritytutorial.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AccountMapperDecorator implements AccountMapper {

    @Autowired
    @Qualifier("delegate")
    private AccountMapper delegate;

    @Override
    public AccountDto toAccountDto(Account account) {
        var something = delegate.toAccountDto(account);
        var username = something.getUsername();
        var password = something.getPassword();

        return new AccountDto(username, password, "", 100, "USER");
    }
}
