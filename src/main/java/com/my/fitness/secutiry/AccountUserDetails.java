package com.my.fitness.secutiry;

import com.my.fitness.dto.AccountEntityDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Customer user details
 */
public class AccountUserDetails implements UserDetails {

    /**
     * Username (uuid)
     */
    private String username;

    /**
     * Password
     */
    private String password;

    /**
     * Constructor
     * @param accountDto Account data transfer object
     */
    public AccountUserDetails(AccountEntityDto accountDto) {
        this.username = accountDto.getUuid();
        this.password = UUID.randomUUID().toString();
    }

    /**
     * Get authorities
     *
     * @return Authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * Get password
     *
     * @return Password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Get username
     *
     * @return Username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Is user account not expired
     *
     * @return Is user account not expired check result
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Is user account not locked
     *
     * @return Is user account not locked check result
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Is credential not expired
     *
     * @return Is credential not expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is user account enabled
     *
     * @return Is user account enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}