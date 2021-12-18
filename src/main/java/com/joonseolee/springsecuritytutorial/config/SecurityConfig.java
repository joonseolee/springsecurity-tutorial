package com.joonseolee.springsecuritytutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .loginPage("/loginPage")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("passwd")
                .loginProcessingUrl("/login")
                .successHandler((request, response, authentication) -> {
                    log.info("authentication [{}]", authentication.getName());
                    response.sendRedirect("/");
                })
                .failureHandler((request, response, exception) -> {
                    log.info("exception [{}]", exception.getMessage());
                    response.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("login")
                .addLogoutHandler((request, response, authentication) -> {
                    var session = request.getSession();
                    session.invalidate();
                })
                .logoutSuccessHandler((request, response, authentication) ->
                        response.sendRedirect("/login"))
                .deleteCookies("remember-me") // 서버에서 자동으로 만든 쿠기명
                .and()
                .rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(3600)
                .userDetailsService(userDetailsService)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false) // default value 가 false 인데 기능은 기존세션만료
                .and()
                .sessionFixation()
                .changeSessionId(); // 기본값이 세션 자동 변경됨
    }
}
