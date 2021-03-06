package com.joonseolee.springsecuritytutorial.security.factory;

import com.joonseolee.springsecuritytutorial.security.service.impl.SecurityResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;

import java.util.LinkedHashMap;
import java.util.List;

@RequiredArgsConstructor
public class MethodResourcesFactoryBean implements FactoryBean<LinkedHashMap<String, List<ConfigAttribute>>> {

    private final SecurityResourceService securityResourceService;
    private LinkedHashMap<String, List<ConfigAttribute>> resourceMap;
    private final String resourceType;

    @Override
    public LinkedHashMap<String, List<ConfigAttribute>> getObject() throws Exception {
        if (resourceMap == null) {
            init();
        }

        return resourceMap;
    }

    private void init() {
        if ("method".equals(resourceType)) {
            resourceMap = securityResourceService.getMethodResourceList();
        } else if ("pointcut".equals(resourceType)) {
            resourceMap = securityResourceService.getPointcutResourceList();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
