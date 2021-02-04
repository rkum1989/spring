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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdx.domain.ClientBuilder;
import com.mdx.domain.User;
import com.mdx.repository.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
public class AccountContollerTest {

    public static Logger log =  LoggerFactory.getLogger(AccountContollerTest.class);


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @SuppressWarnings("unused")
	@Autowired
    private ClientDetailsService clientDetialsService;

    @Before
    public void setUp() {
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain).build();

         @SuppressWarnings("unused")
		BaseClientDetails testClient = (BaseClientDetails) new ClientBuilder("testclient")
                    .secret("testclientsecret")
                    .authorizedGrantTypes("password")
                    .scopes("read", "wirte")
                    .autoApprove(true)
                    .build();

         //clientDetialsService.addClient(testClient);

         User user = null; // createDefaultUser("testuser", passwordEncoder.encode("testpassword"), "max", "Mustermann", "myemail@test.de");

         users.deleteAll();
         users.save(user);

    }

    @Test
    public void testRetriveAccountDetailsWithValidAccessToken() throws Exception {
        mvc.perform(get("/api/me")
                .header("Authorization", "Bearer " + validAccessToken())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.userAuthentication.name").value("testuser"))
                .andExpect(jsonPath("$.authorities[0].authority").value("ROLE_USER"));
    }

    @Test
    public void testReceiveHTTPStatusUnauthenticatedWithoutAuthorizationHeader() throws Exception{
        mvc.perform(get("/api/me")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    private String validAccessToken() throws Exception {  
        String username = "testuser";
        String password = "testpassword";

        MockHttpServletResponse response = mvc
            .perform(post("/oauth/token")
                    .header("Authorization", "Basic "
                           + new String(Base64Utils.encode(("testclient:testclientsecret")
                            .getBytes())))
                    .param("username", username)
                    .param("password", password)
                    .param("grant_type", "password"))
            .andDo(print())
            .andReturn().getResponse();

    return new ObjectMapper()
            .readValue(response.getContentAsByteArray(), OAuthToken.class)
            .accessToken;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class OAuthToken {
        @JsonProperty("access_token")
        public String accessToken;
    }
}