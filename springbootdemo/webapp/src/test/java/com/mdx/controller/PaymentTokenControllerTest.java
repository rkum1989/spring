////////////////////////////////////////////////////////////////////////////////////////////
// @ID: PaymentTokenControllerTest.java
// @Author: Rituraj Kumar
// Date: 3/11/2018.
//
// Purpose:
// Test cases for Controller
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdx.model.PaymentToken;
import com.mdx.service.PaymentTokenService;
import org.apache.catalina.filters.CorsFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PaymentTokenControllerTest {

    @Mock
    private PaymentTokenService paymentTokenService;

    @InjectMocks
    private PaymentTokenController paymentTokenController;

    private static MockMvc mockMvc;

    private PaymentToken paymentToken;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentTokenController).addFilters(new CorsFilter()).build();
        paymentToken = new PaymentToken();
        paymentToken.setTokenReferenceId(1L);
        paymentToken.setTokenNumber("123");
        paymentToken.setTokenExpiryDate(new Date(System.currentTimeMillis()));
        paymentToken.setPanSource("PanSourceSample");
        paymentToken.setDeviceId("DE123");
        paymentToken.setTokenRequesterId("99");
        when((paymentTokenService.createPaymentToken(any(PaymentToken.class)))).thenReturn(paymentToken);
        when(paymentTokenService.getPaymentToken(anyLong(), anyString())).thenReturn(paymentToken);
    }

    @AfterEach
    public void tearDown() {
        Mockito.reset(paymentTokenService);
    }

    @Test
    public void createPaymentTokenTest() throws Exception {
        mockMvc.perform(post("/tokenservice/api/v1/token")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(asJsonString(paymentToken))
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());

        verify(paymentTokenService, times(1)).createPaymentToken(any(PaymentToken.class));
        verifyNoMoreInteractions(paymentTokenService);
    }

    @Test
    public void getPaymentTokenTest() throws Exception {
        mockMvc.perform(get("/tokenservice/api/v1/token/1/99")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

        verify(paymentTokenService, times(1)).getPaymentToken(anyLong(), anyString());
        verifyNoMoreInteractions(paymentTokenService);
    }

    public String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
