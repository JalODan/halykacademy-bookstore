package kz.halykacademy.bookstore.security;


import kz.halykacademy.bookstore.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;


public class SecurityUser implements UserDetails {

    private final String password;
    private final String username;
    private final boolean isActive;
    private final Set<SimpleGrantedAuthority> authorities;

    public SecurityUser(String password, String username, boolean isActive, Set<SimpleGrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    public static SecurityUser fromUser(User user) {

        return new SecurityUser(
                user.getPassword(),
                user.getUsername(),
                user.getActive(),
                user.getRole().getAuthorities()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
