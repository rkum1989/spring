/*////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: MyControllerTest.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.test.server.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mdx.resource.server.MyApp;
import com.mdx.resource.test.server.config.AuthorizationServerConfig;
import com.mdx.resource.test.server.config.OAuthHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { MyApp.class, AuthorizationServerConfig.class})
@WebAppConfiguration
public class MyControllerTest {
	
	// [ data-members..!]
	private MockMvc	mvc;

	@Autowired
	private WebApplicationContext webapp;

	@Autowired
	private OAuthHelper helper;

	@Before
	public void init() {
		final String METHOD_NAME = "init";
		    
		mvc = MockMvcBuilders.webAppContextSetup(webapp).apply(springSecurity()).alwaysDo(print()).build();
	}

	@Test
	public void testHelloWithRole() throws Exception {
		final String METHOD_NAME = "testHelloWithRole";
		    
		RequestPostProcessor bearerToken = helper.bearerToken("myclientwith");
		mvc.perform(get("/hello").with(bearerToken)).andExpect(status().isOk());
	}

	@Test
	public void testHelloWithoutRole() throws Exception {
		final String METHOD_NAME = "testHelloWithoutRole";
		   
		RequestPostProcessor bearerToken = helper.bearerToken("myclientwithout");
		mvc.perform(get("/hello").with(bearerToken)).andExpect(status().isForbidden());
	}
}
*/