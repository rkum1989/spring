////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: OAuthHelper.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.test.server.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

@Component
public class OAuthHelper {
	
	@Autowired
	ClientDetailsService clientDetailsService;
	
	@Autowired
	AuthorizationServerTokenServices tokenService;

	// For use with MockMvc
	public RequestPostProcessor bearerToken(final String clientid) {
		final String METHOD_NAME = "OAuthHelper::bearerToken";
		return mockRequest -> {
			OAuth2AccessToken token = createAccessToken(clientid);
			mockRequest.addHeader("Authorization", "Bearer " + token.getValue());
			return mockRequest;
		};
	}

	// createAccessToken()-method
	public OAuth2AccessToken createAccessToken(final String clientId) {
		final String METHOD_NAME = "OAuthHelper::createAccessToken";
		// Look up authorities, resourceIds and scopes based on clientId
		ClientDetails client = clientDetailsService.loadClientByClientId(clientId);
		Collection<GrantedAuthority> authorities = client.getAuthorities();
		Set<String> resourceIds = client.getResourceIds();
		Set<String> scopes = client.getScope();

		// Default values for other parameters
		Map<String, String> requestParameters = Collections.emptyMap();
		boolean approved = true;
		String redirectUrl = null;
		Set<String> responseTypes = Collections.emptySet();
		Map<String, Serializable> extensionProperties = Collections.emptyMap();

		// Create request
		OAuth2Request oAuth2Request = new OAuth2Request(requestParameters, clientId, authorities, approved, scopes,
				resourceIds, redirectUrl, responseTypes, extensionProperties);

		// Create OAuth2AccessToken
		User userPrincipal = new User("user", "", true, true, true, true, authorities);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
		OAuth2Authentication auth = new OAuth2Authentication(oAuth2Request, authenticationToken);
		return tokenService.createAccessToken(auth);
	}
}
