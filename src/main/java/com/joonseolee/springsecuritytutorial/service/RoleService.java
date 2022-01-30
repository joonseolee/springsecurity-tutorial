package com.joonseolee.springsecuritytutorial.service;

import com.joonseolee.springsecuritytutorial.domain.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}