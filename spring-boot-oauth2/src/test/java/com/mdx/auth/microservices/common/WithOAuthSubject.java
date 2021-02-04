////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: WithOAuthSubject.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.auth.microservices.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import org.springframework.security.test.context.support.WithSecurityContext;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithOAuthSubjectSecurityContextFactory.class)
public @interface WithOAuthSubject {

    String[] scopes() default {"myapi:write", "myapi:read"};

    String subjectId() default "a1de7cc9-1b3a-4ecd-96fa-dab6059ccf6f";

}

