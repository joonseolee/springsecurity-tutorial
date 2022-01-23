package com.joonseolee.springsecuritytutorial.service.impl;

import com.joonseolee.springsecuritytutorial.domain.Account;
import com.joonseolee.springsecuritytutorial.domain.AccountMapper;
import com.joonseolee.springsecuritytutorial.repository.UserRepository;
import com.joonseolee.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountMapper accountMapper;

    @Transactional
    @Override
    public void createUser(Account account) {
        userRepository.save(account);
    }
}
