package com.joonseolee.springsecuritytutorial.repository;

import com.joonseolee.springsecuritytutorial.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
