////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: SecuredApplicationTests.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mdx.SecuredApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecuredApplication.class)
public class SecuredApplicationTests {

	@Test
	public void contextLoads() {
	}

}
