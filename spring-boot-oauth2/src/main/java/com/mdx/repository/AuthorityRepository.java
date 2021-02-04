////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: AuthorityRepository.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mdx.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
	
}
