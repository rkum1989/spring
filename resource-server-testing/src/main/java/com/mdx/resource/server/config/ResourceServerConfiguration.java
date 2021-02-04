////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: ResourceServerConfiguration.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.server.config;

import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		final String METHOD_NAME = "ResourceServerConfig::configure-1";
		http.authorizeRequests().anyRequest().access("#oauth2.hasScope('myscope')");
	}

	@Override
	public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
		final String METHOD_NAME = "ResourceServerConfig::configure-ResourceServerSecurity";
		resources.resourceId("myresource").tokenStore(tokenStore());
   
	}

//==============================================//
//	JWT tokens usage
//==============================================//
//	To use JWT tokens you need a JwtTokenStore in your Authorization Server. 
//	The Resource Server also needs to be able to decode the tokens so the JwtTokenStore has a dependency 
//	on a JwtAccessTokenConverter, and the same implementation is needed by both the Authorization Server 
//	and the Resource Server. 
//	
//	The tokens are signed by default, and the Resource Server also has to be able to verify the signature, 
//	so it either needs the same symmetric (signing) key as the Authorization Server (shared secret, or symmetric key), 
//	or it needs the public key (verifier key) that matches the private key (signing key) in the Authorization Server 
//	(public-private or asymmetric key). 
//	
//	The public key (if available) is exposed by the Authorization Server on the /oauth/token_key endpoint, 
//	which is secure by default with access rule "denyAll()". 
//	
//	You can open it up by injecting a standard SpEL expression into the AuthorizationServerSecurityConfigurer 
//	(e.g. "permitAll()" is probably adequate since it is a public key).
//
//	To use the JwtTokenStore you need "spring-security-jwt" on your classpath (you can find it in the same github repository 
//	as Spring OAuth but with a different release cycle).

	
	@Bean
	public JwtTokenStore tokenStore() throws Exception {
		final String METHOD_NAME = "ResourceServerConfig::tokenStore";
		// preparing the accessTokenConverter instance..!
		JwtAccessTokenConverter enhancer = new JwtAccessTokenConverter();
		enhancer.setVerifierKey(getKey("rsa"));
		enhancer.afterPropertiesSet();
		return new JwtTokenStore(enhancer);
	}

	// getKey()-method
	public static String getKey(final String resource) throws Exception {
		final String METHOD_NAME = "ResourceServerConfig::getKey";
		URI uri = ResourceServerConfiguration.class.getClassLoader().getResource(resource).toURI();
		return IOUtils.toString(uri);
	}
}
