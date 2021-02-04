////////////////////////////////////////////////////////////////////////////////////////////
// @ID: PaymentTokenRepositoryTest.java
// @Author: Rituraj Kumar
// Date: 3/11/2018.
//
// Purpose:
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
@ActiveProfiles("sit")
public class PaymentTokenRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PaymentTokenRepository paymentTokenRepository ;

    @Test
    @Disabled
    public void save() {

        //assertTrue(found.iterator().hasNext());
    }
}
