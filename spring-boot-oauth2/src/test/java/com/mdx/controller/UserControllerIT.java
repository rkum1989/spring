////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: UserControllerIT.java
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

import com.mdx.SecuredApplication;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecuredApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("default")
public class UserControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TokenStore tokenStore;

    @Before
    public void setUp() {
        final OAuth2AccessToken token = new DefaultOAuth2AccessToken("FOO");
        final ClientDetails client = new BaseClientDetails("client", null, "read", "client_credentials", "ROLE_CLIENT");
        final OAuth2Authentication authentication = new OAuth2Authentication(
                new TokenRequest(null, "client", null, "client_credentials").createOAuth2Request(client), null);
        tokenStore.storeAccessToken(token, authentication);
    }

    @Test
    public void testGivenPathUsersWhenGettingForEntityThenStatusCodeIsOk() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer FOO");
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Given Path Users
        final UriComponentsBuilder uri = UriComponentsBuilder.fromPath("/api/users");
        // When Getting For Entity
        final ResponseEntity<String> response = testRestTemplate.exchange(uri.build().toUri(), HttpMethod.GET, new HttpEntity<>(headers), String.class);
        // Then Status Code Is Ok
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}

