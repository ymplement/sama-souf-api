package com.samasouf.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samasouf.domain.User;
import com.samasouf.domain.security.Permission;
import com.samasouf.domain.security.Role;
import com.samasouf.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + usernameOrEmail));

        if (!user.isActive()) {
            throw new UsernameNotFoundException("User is not active: " + usernameOrEmail);
        }

        return UserPrincipal.create(user);
    }

    public static class UserPrincipal implements UserDetails {
        private final Long id;
        private final String username;
        private final String email;
        private final String password;
        private final boolean active;
        private final Collection<? extends GrantedAuthority> authorities;

        public UserPrincipal(Long id, String username, String email, String password, boolean active,
                Collection<? extends GrantedAuthority> authorities) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.active = active;
            this.authorities = authorities;
        }

        public static UserPrincipal create(User user) {
            Set<GrantedAuthority> authorities = new HashSet<>();

            // Add role-based authorities
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

                // Add permission-based authorities
                for (Permission permission : role.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }

            return new UserPrincipal(user.getUser_id(), user.getUsername(), user.getEmail(), user.getPassword(),
                    user.isActive(), authorities);
        }

        public Long getId() {
            return id;
        }

        public String getEmail() {
            return email;
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
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return active;
        }

        public Set<String> getRoles() {
            return authorities.stream().map(GrantedAuthority::getAuthority).filter(auth -> auth.startsWith("ROLE_"))
                    .map(auth -> auth.substring(5)).collect(Collectors.toSet());
        }

        public Set<String> getPermissions() {
            return authorities.stream().map(GrantedAuthority::getAuthority).filter(auth -> !auth.startsWith("ROLE_"))
                    .collect(Collectors.toSet());
        }
    }
}
