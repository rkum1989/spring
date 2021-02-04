////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: OAuthHelper.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.auth.microservices.common;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Map;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import org.springframework.security.test.context.support.WithSecurityContextFactory;

import com.google.common.collect.ImmutableMap;

//Factory class for handling the custom annotation:
public class WithOAuthSubjectSecurityContextFactory implements WithSecurityContextFactory<WithOAuthSubject> {

    private DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();

    @Override
    public SecurityContext createSecurityContext(WithOAuthSubject withOAuthSubject) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        // Copy of response from https://myidentityserver.com/identity/connect/accesstokenvalidation
        Map<String, ?> remoteToken = ImmutableMap.<String, Object>builder()
            .put("iss", "https://myfakeidentity.example.com/identity")
            .put("aud", "oauth2-resource")
            .put("exp", OffsetDateTime.now().plusDays(1L).toEpochSecond() + "")
            .put("nbf", OffsetDateTime.now().plusDays(1L).toEpochSecond() + "")
            .put("client_id", "my-client-id")
            .put("scope", Arrays.asList(withOAuthSubject.scopes()))
            .put("sub", withOAuthSubject.subjectId())
            .put("auth_time", OffsetDateTime.now().toEpochSecond() + "")
            .put("idp", "idsrv")
            .put("amr", "password")
            .build();

        OAuth2Authentication authentication = defaultAccessTokenConverter.extractAuthentication(remoteToken);
        context.setAuthentication(authentication);
        return context;
    }
}

//I use a copy of the response from our identity server for creating a realistic OAuth2Authentication. You can probably just copy my code. If you want to repeat the process for your identity server, place a breakpoint in org.springframework.security.oauth2.provider.token.RemoteTokenServices#loadAuthentication or org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices#extractAuthentication, depending on whether you have configured a custom ResourceServerTokenServices or not.
//shareimprove this answer