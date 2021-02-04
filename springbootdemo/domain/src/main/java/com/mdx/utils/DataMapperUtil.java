////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: DataMapperUtil.java
//  @Author: Shekhar Cambam
//
//	CONFIDENTIAL -- Copyright 2018 MdxDev. 
//	This is confidential and proprietary information of Digital Insight.
//	Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.utils;


import com.google.common.base.Preconditions;
import com.mdx.domain.PaymentTokenEntity;
import com.mdx.model.PaymentToken;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataMapperUtil {
    // The logger for this Util
    private static final Logger LOGGER = LoggerFactory.getLogger(DataMapperUtil.class);

    @Autowired
    private ModelMapper modelMapper;

    // convertModelToEntity()-method
    public PaymentTokenEntity convertModelToEntity(PaymentToken paymentToken) {
        Preconditions.checkNotNull(paymentToken);
        PaymentTokenEntity entity = modelMapper.map(paymentToken, PaymentTokenEntity.class);

        return entity;
    }

    // convertEntityToModel()-method
    public PaymentToken convertEntityToModel(PaymentTokenEntity paymentTokenEntity) {
        Preconditions.checkNotNull(paymentTokenEntity);
        PaymentToken entity = modelMapper.map(paymentTokenEntity, PaymentToken.class);

        return entity;
    }


}