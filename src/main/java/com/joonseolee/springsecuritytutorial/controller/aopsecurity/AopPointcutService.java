package com.joonseolee.springsecuritytutorial.controller.aopsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AopPointcutService {

    public void pointcutSecured() {
        log.info("pointcutSecured");
    }

    public void notSecured() {
        System.out.println("notSecured");
    }
}
