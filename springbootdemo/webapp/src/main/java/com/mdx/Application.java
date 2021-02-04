////////////////////////////////////////////////////////////////////////////////////////////
// @ID: Application.java
// @Author: Rituraj Kumar
// Date: 3/10/2018.
//
// Purpose:
// Contains the Application class definition.
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx;

import com.mdx.config.ApplicationProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.mdx.*")
@EnableAsync
@EnableConfigurationProperties(ApplicationProperties.class)
public class Application extends SpringBootServletInitializer {

   /* private static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

    private static final ImmutableSet<String> VALID_ENVIRONMENTS = ImmutableSet.of("desktop", "et", "pni", "prod");

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        validateProfile();
        //SystemPropertiesResource.get();
        super.onStartup(servletContext);
    }

    private static void validateProfile() {
        String activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE);
        if (activeProfile == null || activeProfile.trim().length() == 0) {
            System.out.println("Spring activeProfile not specified !, set JVM parameter -Dspring.profiles.active");
            throw new RuntimeException("Spring activeProfile not specified !, set JVM parameter -Dspring.profiles.active");
        }

        if (!VALID_ENVIRONMENTS.contains(activeProfile)) {
            System.out
                    .println(
                            activeProfile + "; Invalid 'spring.profiles.active' specified !, valid environments are :" + VALID_ENVIRONMENTS
                                    .toString());
            throw new RuntimeException(
                    activeProfile + "; Invalid 'spring.profiles.active' specified !, valid environments are :" + VALID_ENVIRONMENTS
                            .toString());
        }
    }*/


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
      /*  if (System.getProperty(SPRING_PROFILES_ACTIVE) == null) {
            System.setProperty(SPRING_PROFILES_ACTIVE, "desktop");
        }
        validateProfile();*/

        //SystemPropertiesResource.get();

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
