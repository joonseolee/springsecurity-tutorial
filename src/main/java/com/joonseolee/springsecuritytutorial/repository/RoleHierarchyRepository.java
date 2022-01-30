package com.joonseolee.springsecuritytutorial.repository;

import com.joonseolee.springsecuritytutorial.domain.RoleHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {

    RoleHierarchy findByChildName(String roleName);
}
