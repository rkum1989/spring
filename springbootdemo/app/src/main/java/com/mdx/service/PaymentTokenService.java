////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: PaymentTokenService.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.service;

import com.mdx.model.PaymentToken;
import com.mdx.model.Reward;

import java.util.List;


public interface PaymentTokenService {

    PaymentToken createPaymentToken(final PaymentToken paymentToken);

    PaymentToken getPaymentToken(final Long tokenReferenceId, final String tokenRequesterId);

    List<Reward> getRewards(final Long tokenReferenceId, final String tokenRequesterId);
}


