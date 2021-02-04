////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: AccountControllerTest.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mdx.SecuredApplication;
import com.mdx.auth.microservices.common.OAuthHelper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecuredApplication.class)
@WebAppConfiguration
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext webapp;

    @Autowired
    private OAuthHelper authHelper;


	@Autowired
    private FilterChainProxy filterChainProxy;    
    
    private MockMvc restMvc;

    @Before
    public void setup() {
        restMvc = MockMvcBuilders.webAppContextSetup(webapp).addFilter(filterChainProxy).build();
    }

    @Test
    public void testHelloAnonymous() throws Exception {
        ResultActions resultActions = restMvc.perform(post("/hello")).andDo(print());
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void testHelloAuthenticated() throws Exception {
        RequestPostProcessor bearerToken = authHelper.addBearerToken("test", "ROLE_USER");
        ResultActions resultActions = restMvc.perform(post("/hello").with(bearerToken)).andDo(print());
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

    @Test
    public void testHelloAgainAnonymous() throws Exception {
        ResultActions resultActions = restMvc.perform(post("/hello-again")).andDo(print());
        resultActions
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testHelloAgainAuthenticated() throws Exception {
        RequestPostProcessor bearerToken = authHelper.addBearerToken("test", "ROLE_USER");
        ResultActions resultActions = restMvc.perform(post("/hello-again").with(bearerToken)).andDo(print());
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("hello again"));
    }
}