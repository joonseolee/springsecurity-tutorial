package com.joonseolee.springsecuritytutorial.security.configs;

import com.joonseolee.springsecuritytutorial.security.factory.MethodResourcesFactoryBean;
import com.joonseolee.springsecuritytutorial.security.service.impl.SecurityResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.util.Objects;

// @Secured 이런 권한설정을 할때 꼭 아래 아노테이션을 적어줘야한다.
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private SecurityResourceService securityResourceService;

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return new MapBasedMethodSecurityMetadataSource();
    }

    @Bean
    public MapBasedMethodSecurityMetadataSource mapBasedMethodSecurityMetadataSource() throws Exception {
        return new MapBasedMethodSecurityMetadataSource(Objects.requireNonNull(methodResourcesFactoryBean().getObject()));
    }

    @Bean
    public MethodResourcesFactoryBean methodResourcesFactoryBean() {
        return new MethodResourcesFactoryBean(securityResourceService);
    }
}
