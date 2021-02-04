////////////////////////////////////////////////////////////////////////////////////////////
// @ID: Token_PaymentTokenController.java
// @Author: Rituraj Kumar
// Date: 3/31/2018.
//
// Purpose:
// Controller class for Card and Token.
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.controller;


import com.mdx.model.PaymentToken;
import com.mdx.service.PaymentTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping(path = "tokenservice/api/v1")
@RestController
public class PaymentTokenController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentTokenController.class.getName());

    private PaymentTokenService paymentTokenService;

    @Autowired
    public void paymentTokenController(PaymentTokenService paymentTokenService) {
        this.paymentTokenService = paymentTokenService;
    }

    @RequestMapping(path = "/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PaymentToken> createToken(@Valid @RequestBody PaymentToken token) {
        logger.info("createToken" + token);

        return Optional.of(paymentTokenService.createPaymentToken(token))
                .map(u -> new ResponseEntity<PaymentToken>(u, HttpStatus.CREATED))
                .orElse(new ResponseEntity<PaymentToken>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(path = "/token/{tokenReferenceId}/{tokenRequesterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PaymentToken> getPaymentToken(@PathVariable(value = "tokenReferenceId") Long tokenReferenceId,
                                                 @PathVariable(value = "tokenRequesterId") final String tokenRequesterId) {
        logger.info("getPaymentToken");

        return Optional.of(paymentTokenService.getPaymentToken(tokenReferenceId, tokenRequesterId))
                .map(u -> new ResponseEntity<PaymentToken>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<PaymentToken>(HttpStatus.NOT_FOUND));
    }


}
