package com.joonseolee.springsecuritytutorial.service.impl;

import com.joonseolee.springsecuritytutorial.domain.Account;
import com.joonseolee.springsecuritytutorial.domain.AccountMapper;
import com.joonseolee.springsecuritytutorial.repository.UserRepository;
import com.joonseolee.springsecuritytutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

    /**
     * ROLE_MANAGER 권한만 가지고있는 유저만 인가처리
     */
    @Override
    @Secured("ROLE_MANAGER")
    public void order() {
        log.info("Hello here is the order method.");
    }
}
