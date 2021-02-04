////////////////////////////////////////////////////////////////////////////////////////////
// @ID: PaymentTokenServiceTest.java
// @Author: Rituraj Kumar
// Date: 3/17/2018.
//
// Purpose:
// Test cases for service class
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.service;


import com.mdx.domain.PaymentTokenEntity;
import com.mdx.exception.ObjectNotFoundException;
import com.mdx.model.PaymentToken;
import com.mdx.repository.PaymentTokenRepository;
import com.mdx.utils.DataMapperUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class PaymentTokenServiceTest {

    @Mock
    private PaymentTokenRepository paymentTokenRepository;

    @Mock
    private DataMapperUtil dataMapperUtil;

    @InjectMocks
    private PaymentTokenServiceImpl service;

    private PaymentToken token;

    private PaymentTokenEntity entity;

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
        token = new PaymentToken();
        token.setTokenReferenceId(1L);
        token.setTokenNumber("123");
        token.setTokenExpiryDate(new Date(System.currentTimeMillis()));
        token.setPanSource("PanSourceSample");
        token.setDeviceId("DE123");
        token.setTokenRequesterId("99");
        entity = new PaymentTokenEntity();
        entity.setTokenReferenceId(2L);
        entity.setTokenNumber("1234");
        entity.setTokenExpiryDate(new Date(System.currentTimeMillis()));
        entity.setPanSource("PanSourceSample2");
        entity.setDeviceId("DE1234");
        entity.setTokenRequesterId("999");
    }

    @AfterEach
    public void clean() {
        Mockito.reset(paymentTokenRepository);
    }

    @Test
    public void createPaymentTokenTest() throws Exception {
        when(paymentTokenRepository.save(dataMapperUtil.convertModelToEntity(any(PaymentToken.class)))).thenReturn(entity);
        when(dataMapperUtil.convertEntityToModel(any(PaymentTokenEntity.class))).thenReturn(token);
        PaymentToken response = service.createPaymentToken(token);

        assertNotNull(response);
        assertThat(response.getTokenReferenceId(), is(equalTo(1L)));
        assertThat(response.getDeviceId(), is(equalTo("DE123")));
        assertThat(response.getPanSource(), is(equalTo("PanSourceSample")));
        assertThat(response.getTokenExpiryDate(), notNullValue());
        assertThat(response.getTokenRequesterId(), is(equalTo("99")));
        assertThat(response.getTokenNumber(), is(equalTo("123")));
        verify(paymentTokenRepository, times(1)).save(dataMapperUtil.convertModelToEntity(token));
        verifyNoMoreInteractions(paymentTokenRepository);

    }

    @Test
    public void createPaymentTokenForFailureScenarioTest() throws Exception {
        when(paymentTokenRepository.save(dataMapperUtil.convertModelToEntity(any(PaymentToken.class)))).thenReturn(null);

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            service.createPaymentToken(token);
        });
        verify(paymentTokenRepository, times(1)).save(dataMapperUtil.convertModelToEntity(token));
        verifyNoMoreInteractions(paymentTokenRepository);
    }

    @Test
    public void getPaymentTokenTest() throws Exception {
        when(paymentTokenRepository.findByTokenReferenceIdAndTokenRequesterId(anyLong(), anyString())).thenReturn(Optional.ofNullable(entity));
        when(dataMapperUtil.convertEntityToModel(any(PaymentTokenEntity.class))).thenReturn(token);
        PaymentToken response = service.getPaymentToken(token.getTokenReferenceId(), token.getTokenRequesterId());

        assertThat(response, notNullValue());
        assertThat(response.getTokenReferenceId(), is(equalTo(1L)));
        assertThat(response.getDeviceId(), is(equalTo("DE123")));
        assertThat(response.getPanSource(), is(equalTo("PanSourceSample")));
        assertThat(response.getTokenExpiryDate(), notNullValue());
        assertThat(response.getTokenRequesterId(), is(equalTo("99")));
        assertThat(response.getTokenNumber(), is(equalTo("123")));
        verify(paymentTokenRepository, times(1)).findByTokenReferenceIdAndTokenRequesterId(anyLong(), anyString());
        verifyNoMoreInteractions(paymentTokenRepository);
    }

    @Test
    public void getPaymentTokenForExceptionScenarioTest() throws Exception {
        when(paymentTokenRepository.findByTokenReferenceIdAndTokenRequesterId(anyLong(), anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            service.getPaymentToken(token.getTokenReferenceId(), token.getTokenRequesterId());
        });
        verify(paymentTokenRepository, times(1)).findByTokenReferenceIdAndTokenRequesterId(anyLong(), anyString());
        verifyNoMoreInteractions(paymentTokenRepository);
    }
}
