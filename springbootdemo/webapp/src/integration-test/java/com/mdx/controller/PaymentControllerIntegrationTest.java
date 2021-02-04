////////////////////////////////////////////////////////////////////////////////////////////
// @ID: PaymentControllerIntegrationTest.java
// @Author: Rituraj Kumar
// Date: 4/4/2018.
//
// Purpose:
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class PaymentControllerIntegrationTest {
//, properties = {"server.port=8443"}

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template = new TestRestTemplate();

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
    //@Autowired
    //private TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testRetrieveStudentCourse() throws JSONException {
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(mediaTypeList);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        //ResponseEntity<String> response = restTemplate.getForEntity(createURLWithPort("/tokenservice/api/v1/token/1/123"), String.class);
        /*ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tokenservice/api/v1/token/1/123"),
                HttpMethod.GET, entity, String.class);*/
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        String token = response.getBody();
        System.err.print(token);
        Assertions.assertNotNull(token);
    }

   /* private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }*/

   /* @TestConfiguration
    static class Config {

        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().setConnectTimeout(1000).setReadTimeout(1000);
        }

    }*/
}
