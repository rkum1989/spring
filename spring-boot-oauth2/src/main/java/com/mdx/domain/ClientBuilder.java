////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: SocialApplication.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import static java.util.Collections.addAll;


public final class ClientBuilder {
	
	private final String clientId;
	private Collection<String> authorizedGrantTypes = new LinkedHashSet<>();
	private Collection<String> authorities = new LinkedHashSet<>();
	private Integer accessTokenValiditySeconds;
	private Integer refreshTokenValiditySeconds;
	private Collection<String> scopes = new LinkedHashSet<>();
	private Collection<String> autoApproveScopes = new HashSet<>();
	private String secret;
	private Set<String> registeredRedirectUris = new HashSet<>();
	private Set<String> resourceIds = new HashSet<>();
	private boolean autoApprove = true;
	private Map<String, Object> additionalInformation = new LinkedHashMap<>();

	public ClientBuilder(String clientId) {
		this.clientId = clientId;
	}

	public  ClientDetails build() {
		BaseClientDetails result = new BaseClientDetails();
		result.setClientId(clientId);
		result.setAuthorizedGrantTypes(authorizedGrantTypes);
		result.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
		result.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);
		result.setRegisteredRedirectUri(registeredRedirectUris);
		result.setClientSecret(secret);
		result.setScope(scopes);
		result.setAuthorities(AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()])));
		result.setResourceIds(resourceIds);
		result.setAdditionalInformation(additionalInformation);
		if (autoApprove) {
			result.setAutoApproveScopes(scopes);
		} else {
			result.setAutoApproveScopes(autoApproveScopes);
		}
		return result;
	}

	public  ClientBuilder resourceIds(String... resourceIds) {
		addAll(this.resourceIds, resourceIds);
		return this;
	}

	public  ClientBuilder redirectUris(String... registeredRedirectUris) {
		addAll(this.registeredRedirectUris, registeredRedirectUris);
		return this;
	}

	public  ClientBuilder authorizedGrantTypes(String... authorizedGrantTypes) {
		addAll(this.authorizedGrantTypes, authorizedGrantTypes);
		return this;
	}

	public  ClientBuilder accessTokenValiditySeconds(int accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		return this;
	}

	public  ClientBuilder refreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
		return this;
	}

	public  ClientBuilder secret(String secret) {
		this.secret = secret;
		return this;
	}

	public  ClientBuilder scopes(String... scopes) {
		addAll(this.scopes, scopes);
		return this;
	}

	public  ClientBuilder authorities(String... authorities) {
		addAll(this.authorities, authorities);
		return this;
	}

	public  ClientBuilder autoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
		return this;
	}

	public  ClientBuilder autoApprove(String... scopes) {
		addAll(this.autoApproveScopes, scopes);
		return this;
	}

	public  ClientBuilder additionalInformation(Map<String, ?> map) {
		this.additionalInformation.putAll(map);
		return this;
	}

	public  ClientBuilder additionalInformation(String... pairs) {
		for (String pair : pairs) {
			String separator = ":";
			if (!pair.contains(separator) && pair.contains("=")) {
				separator = "=";
			}
			int index = pair.indexOf(separator);
			String key = pair.substring(0, index > 0 ? index : pair.length());
			String value = index > 0 ? pair.substring(index + 1) : null;
			this.additionalInformation.put(key, value);
		}
		return this;
	}

}
