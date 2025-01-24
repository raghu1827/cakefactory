package com.techeva.cakefactory.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.techeva.cakefactory.account.Account;
import com.techeva.cakefactory.account.AccountService;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .csrf().disable() // Disable CSRF protection
         .formLogin()
             .loginPage("/login")
             .and()
         .authorizeRequests()
             .antMatchers("/account").authenticated()
             .anyRequest().permitAll();
    }

    @Bean
    protected UserDetailsService userDetailsService(AccountService accountService) {
        return username -> {
            Account account = accountService.find(username);
            return new User(account.getEmail(), account.getPassword(), Collections.emptyList());
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
