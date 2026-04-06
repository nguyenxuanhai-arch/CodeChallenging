package com.codechallenge.auth.securities;

import com.codechallenge.auth.entities.Permission;
import com.codechallenge.auth.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.codechallenge.auth.entities.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> auths = new HashSet<>();
        if (user.getRoles() != null) {
            for (Role r : user.getRoles()) {
                auths.add(new SimpleGrantedAuthority(r.getName()));
                if (r.getPermissions() != null) {
                    for (Permission p : r.getPermissions()) {
                        auths.add(new SimpleGrantedAuthority(p.getName()));
                    }
                }
            }
        }
        return auths;
    }

    @Override public String getPassword() { return user.getPassword(); }
    @Override public String getUsername() { return user.getEmail(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }

    public Long getUserId() { return user.getId(); }
    public User getDomainUser() { return user; }
}
