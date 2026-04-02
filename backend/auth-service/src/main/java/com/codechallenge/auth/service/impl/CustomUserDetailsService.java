package com.codechallenge.auth.service.impl;

import com.codechallenge.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.codechallenge.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        User user = userRepository.findById(Long.valueOf(userId)).orElseThrow(
                () -> new UsernameNotFoundException("User khong ton tai")
        );

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
