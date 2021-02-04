////////////////////////////////////////////////////////////////////////////////////////////
// @ID: PaymentTokenEntityTest.java
// @Author: Rituraj Kumar
// Date: 4/2/2018.
//
// Purpose:
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class PaymentTokenEntityTest {
    private PaymentTokenEntity paymentTokenEntity;

    @BeforeEach
    public void init() {
        paymentTokenEntity = new PaymentTokenEntity();
        paymentTokenEntity.setTokenReferenceId(1L);
        paymentTokenEntity.setTokenNumber("123");
        paymentTokenEntity.setTokenExpiryDate(new Date(System.currentTimeMillis()));
        paymentTokenEntity.setPanSource("PanSourceSample");
        paymentTokenEntity.setDeviceId("DE123");
        paymentTokenEntity.setTokenRequesterId("99");

    }

    @Test
    public void employeeSetterAndGetterTest() {
        assertThat(paymentTokenEntity.getTokenReferenceId(), is(equalTo(1L)));
        assertThat(paymentTokenEntity.getDeviceId(), is(equalTo("DE123")));
        assertThat(paymentTokenEntity.getPanSource(), is(equalTo("PanSourceSample")));
        assertThat(paymentTokenEntity.getTokenExpiryDate(), notNullValue());
        assertThat(paymentTokenEntity.getTokenRequesterId(), is(equalTo("99")));
        assertThat(paymentTokenEntity.getTokenNumber(), is(equalTo("123")));
    }

    @Test
    public void equalsTest() {
        Boolean flag = paymentTokenEntity.equals(paymentTokenEntity);

        assertTrue(flag);
    }

    @Test
    public void equalsForInvalidEmployeeInstanceTest() {
        Boolean flag = paymentTokenEntity.equals(Object.class);

        assertFalse(flag);
    }

    @Test
    public void equalsForSuperClassInstanceTest() {
        Object obj = paymentTokenEntity;
        Boolean flag = paymentTokenEntity.equals(obj);

        assertTrue(flag);
    }

    @Test
    public void hashCodeTest() {
        Integer hashCode = paymentTokenEntity.hashCode();

        assertNotNull(hashCode);
        assertEquals(hashCode, Integer.valueOf(paymentTokenEntity.hashCode()));
    }

    @Test
    public void toStringTest() {
        String string = paymentTokenEntity.toString();

        assertNotNull(string);
        assertEquals(string, paymentTokenEntity.toString());
    }
}
