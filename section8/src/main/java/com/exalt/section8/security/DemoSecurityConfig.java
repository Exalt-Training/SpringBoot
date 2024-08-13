package com.exalt.section8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // adding users, passwords, roles
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails riham = User.builder()
                .username("rihamkatout")
                .password("{noop}1218")
                .roles("ADMIN", "MANAGER")
                .build();

        UserDetails muneer = User.builder()
                .username("muneerkatout")
                .password("{noop}1973")
                .roles("MANAGER")
                .build();

        UserDetails siwar = User.builder()
                .username("siwarkatout")
                .password("{noop}2021")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(riham, muneer, siwar);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer.anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                ).logout(LogoutConfigurer::permitAll);
        return httpSecurity.build();
    }
}
