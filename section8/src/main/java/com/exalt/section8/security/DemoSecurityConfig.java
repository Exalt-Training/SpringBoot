package com.exalt.section8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

   // adding users, passwords, roles
   @Bean
   public InMemoryUserDetailsManager userDetailsManager(){
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
}
