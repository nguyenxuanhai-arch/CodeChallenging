package com.codechallenge.auth.services;

import com.codechallenge.auth.repositories.UserRepository;
import com.codechallenge.auth.securities.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var u = userRepository.findWithRolesAndPermissionsByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User không tồn tại vui lòng kiểm tra lại email"));
        return new CustomUserDetails(u);
    }
}
