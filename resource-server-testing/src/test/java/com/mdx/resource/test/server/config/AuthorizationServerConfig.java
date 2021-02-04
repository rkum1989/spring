////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: AuthorizationServerConfig.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.resource.test.server.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.mdx.resource.server.config.ResourceServerConfiguration;

@Configuration
@EnableAuthorizationServer
//@SuppressWarnings("static-method")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
    @Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public OAuthHelper helper() throws Exception {
		final String METHOD_NAME = "AuthorizationServerConfig::helper";
		OAuthHelper helper = new OAuthHelper();
		return helper;
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
	public JwtAccessTokenConverter accessTokenConverter() throws Exception {
		final String METHOD_NAME = "AuthorizationServerConfig::accessTokenConverter";
		
		JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
		jwt.setSigningKey(ResourceServerConfiguration.getKey("rsa"));
		jwt.setVerifierKey(ResourceServerConfiguration.getKey("rsa.pub"));
		jwt.afterPropertiesSet();
		    
		return jwt;
	}

	@Bean
	public AuthorizationServerTokenServices tokenServices() throws Exception {
	    final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	    defaultTokenServices.setAccessTokenValiditySeconds(-1);
	    defaultTokenServices.setTokenStore(tokenStore());
	    return defaultTokenServices;
	}
	
    @Bean
    public TokenStore tokenStore() throws Exception {
		final String METHOD_NAME = "AuthorizationServerConfig::tokenStore";
		
        return new JwtTokenStore(accessTokenConverter());
    }

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		final String METHOD_NAME = "AuthorizationServerConfig::configure-AuthorizationServer";
		
		endpoints
		.authenticationManager(authenticationManager)
		.accessTokenConverter(accessTokenConverter());
	   
	}

//==============================================//
//	Configuring Client Details
//==============================================//
//
//	The ClientDetailsServiceConfigurer (a callback from your AuthorizationServerConfigurer) can be used to define 
//	an in-memory or JDBC implementation of the client details service. 
//	Important attributes of a client are
//
//	    clientId: (required) the client id.
//	    secret: (required for trusted clients) the client secret, if any.
//	    scope: The scope to which the client is limited. If scope is undefined or empty (the default) 
//	    	   the client is not limited by scope.
//	    authorizedGrantTypes: Grant types that are authorized for the client to use. Default value is empty.
//	    authorities: Authorities that are granted to the client (regular Spring Security authorities).
//
//	Client details can be updated in a running application by access the underlying store directly 
//	(e.g. database tables in the case of JdbcClientDetailsService) or through the ClientDetailsManager 
//	interface (which both implementations of ClientDetailsService also implement).
	
	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		final String METHOD_NAME = "AuthorizationServerConfig::confgure-ClientDetailsService";
		  
		clients.inMemory()
		// [ client-1 configuration..!]
		.withClient("myclientwith")
		.authorizedGrantTypes("password")
		.authorities("myauthorities")
		.resourceIds("myresource")
		.scopes("myscope")

		.and()
		// [ client-2 configuration..!]
		.withClient("myclientwithout")
		.authorizedGrantTypes("password")
		.authorities("myauthorities")
		.resourceIds("myresource")
		.scopes(UUID.randomUUID().toString());
	   
	}
}
