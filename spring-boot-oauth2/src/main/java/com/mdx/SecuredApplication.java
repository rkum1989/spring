////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: SecuredApplication.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuredApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuredApplication.class, args);
    }
}
