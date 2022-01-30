package com.joonseolee.springsecuritytutorial.security.service;

import com.joonseolee.springsecuritytutorial.domain.Role;
import com.joonseolee.springsecuritytutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var account = userRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("UsernameNotFoundException has occurred");
        }

        Set<String> userRoles = account.getUserRoles()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());

        List<GrantedAuthority> collect = userRoles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new AccountContext(account, collect);
    }
}
