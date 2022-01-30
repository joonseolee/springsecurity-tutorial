package com.joonseolee.springsecuritytutorial.repository;

import com.joonseolee.springsecuritytutorial.domain.AccountRole;
import com.joonseolee.springsecuritytutorial.domain.AccountRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleId> {
}
