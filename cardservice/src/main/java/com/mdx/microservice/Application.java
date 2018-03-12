////////////////////////////////////////////////////////////////////////
//
//	@Id: Application.java
//  @Author: Shekhar Cambam
//
//	Purpose:
//	Contains the Application class definition.
//
//	All rights reserved.
//
////////////////////////////////////////////////////////////////////////
package com.mdx.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application
{
    /**
     * Initializes a Spring Boot application context for the microservice.
     * @param args Command line arguments for configuring Spring Boot.
     * @throws Throwable Throws an exception within the application's context that extends Throwable.
     */
    public static void main(String[] args) throws Throwable  {
        SpringApplication.run(Application.class, args);
    }
}

