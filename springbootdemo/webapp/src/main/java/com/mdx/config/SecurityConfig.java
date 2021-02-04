////////////////////////////////////////////////////////////////////////////////////////////
// @ID: SecurityConfig.java
// @Author: Rituraj Kumar
// Date: 3/10/2018.
//
// Purpose:
// Contains the Security config details
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String OPERATIONS_MANAGER = "OPERATIONS_MANAGER";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(HttpMethod.PUT, "/users/*").hasAnyRole("AGENT", "OPERATIONS_MANAGER")
                    .antMatchers("/users/*").hasRole("OPERATIONS_MANAGER")
                    .antMatchers("/users").hasRole("OPERATIONS_MANAGER")
                    .and().httpBasic()
                    .and()
                    .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("john")
                    .password("test123").roles("AGENT").and()
                    .withUser("patrik")
                    .password("test123test123").roles("OPERATIONS_MANAGER");
    }

}
