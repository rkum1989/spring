////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: BookingControllerTest.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
//package com.mdx.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.mdx.config.DefaultTestConfiguration;
//import com.mdx.repository.BookingRepository;
//
//
//
//@RunWith(SpringRunner.class)
//@AutoConfigureJsonTesters
//@WebMvcTest
//@Import(DefaultTestConfiguration.class)
//public class BookingControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private JacksonTester<Booking> json;
//
//    @MockBean
//    private BookingRepository bookingRepository;
//
//    @MockBean
//    public ResourceServerTokenServices resourceServerTokenServices;
//
//    @Before
//    public void setUp() throws Exception {
//        // Stub the remote call that loads the authentication object
//        when(resourceServerTokenServices.loadAuthentication(anyString())).thenAnswer(invocation -> SecurityContextHolder.getContext().getAuthentication());
//    }
//
//    @Test
//    @WithOAuthSubject(scopes = {"myapi:read", "myapi:write"})
//    public void mustHaveValidBookingForPatch() throws Exception {
//        mvc.perform(patch(API_URL)
//            .header(AUTHORIZATION, "Bearer foo")
//            .content(json.write(new Booking("myguid", "aes")).getJson())
//            .contentType(MediaType.APPLICATION_JSON_UTF8)
//        ).andExpect(status().is2xxSuccessful());
//    }
//}
