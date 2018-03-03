package com.my.fitness.configuration;


import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Security configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Filter chain proxy
     * @return Filter chain proxy
     */
    @Bean(name = "myFitnessFilterChain")
    public FilterChainProxy filterChainProxy() {
        List<SecurityFilterChain> filterChains = new ArrayList<>();
        /** Resource filter chain */
        filterChains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/resources/**")));
        return new FilterChainProxy(filterChains);
    }

    /**
     * Configure
     * @param web Web security
     * @throws Exception Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     * Configure
     * @param http Http-security
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/dashboard/**").authenticated().and().
                logout().logoutUrl("/logout");
    }
}
