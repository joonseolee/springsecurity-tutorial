package com.joonseolee.springsecuritytutorial.repository;

import com.joonseolee.springsecuritytutorial.domain.AccessIp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {

    AccessIp findByIpAddress(String IpAddress);
}
