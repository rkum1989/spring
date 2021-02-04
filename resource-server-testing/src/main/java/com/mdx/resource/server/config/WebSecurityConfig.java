////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: WebSecurityConfig.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.inMemoryAuthentication().
            withUser("john").password("123").roles("USER").
            and().
            withUser("tom").password("111").roles("ADMIN");
        // @formatter:on
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            ;
        // @formatter:on
    }

}
