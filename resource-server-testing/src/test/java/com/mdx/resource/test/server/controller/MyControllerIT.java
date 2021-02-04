/*////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: SocialApplication.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.test.server.controller;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.client.test.OAuth2ContextSetup;
import org.springframework.security.oauth2.client.test.RestTemplateHolder;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mdx.oauth.common.utils.LoggerUtil;
import com.mdx.resource.server.MyApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApp.class)
@WebIntegrationTest(randomPort = true)
@OAuth2ContextConfiguration(MyControllerIT.MyDetails.class)
public class MyControllerIT implements RestTemplateHolder {
	@Value("http://localhost:${local.server.port}")
	private String host;

	private RestOperations restTemplate = new TestRestTemplate();

	@Rule
	public OAuth2ContextSetup context = OAuth2ContextSetup.standard(this);

	@Override
	public RestOperations getRestTemplate() {
		return restTemplate;
	}
	
	@Override
	public void setRestTemplate(RestOperations restTemplate) {
		this.restTemplate = restTemplate;		
	}

	public String getHost() {
		return host;
	}

	@Test
	public void testHelloOAuth2WithRole() {
		final String METHOD_NAME = "testHelloOAuth2WithRole";
		ResponseEntity<String> entity = getRestTemplate().getForEntity(host + "/hello", String.class);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
	}
	//==========================================================================//
	//	INNER-CLASS::MyDetails
	//==========================================================================//
	public static class MyDetails extends ResourceOwnerPasswordResourceDetails {
		public MyDetails(final Object obj) {
			final String METHOD_NAME = "MyDetails::constructor";
			MyControllerIT it = (MyControllerIT) obj;
			setAccessTokenUri(it.getHost() + "/oauth/token");
			setClientId("myclientwith");
			setUsername("user");
			setPassword("password");
		}
	}
	
}

*/