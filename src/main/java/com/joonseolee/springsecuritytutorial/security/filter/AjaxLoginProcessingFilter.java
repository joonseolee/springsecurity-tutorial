package com.joonseolee.springsecuritytutorial.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joonseolee.springsecuritytutorial.domain.AccountDto;
import com.joonseolee.springsecuritytutorial.security.token.AjaxAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String X_REQUESTED_WITH = "X-Requested-With";

    private ObjectMapper objectMapper = new ObjectMapper();

    public AjaxLoginProcessingFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!isAjax(request)) {
            throw new IllegalStateException("Authentication is not supported.");
        }

        var accountDto = objectMapper.readValue(request.getReader(), AccountDto.class);
        if (!StringUtils.hasText(accountDto.getUsername()) || !StringUtils.hasText(accountDto.getPassword())) {
            throw new IllegalArgumentException("Username or Password is empty.");
        }

        var ajaxAuthenticationToken =
                new AjaxAuthenticationToken(accountDto.getUsername(), accountDto.getPassword());

        return getAuthenticationManager().authenticate(ajaxAuthenticationToken);
    }

    private boolean isAjax(HttpServletRequest request) {
        return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
    }
}
