////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: PaymentTokenServiceImpl.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.service;

import com.google.common.base.Preconditions;
import com.mdx.domain.PaymentTokenEntity;
import com.mdx.exception.ObjectNotFoundException;
import com.mdx.model.PaymentToken;
import com.mdx.model.Reward;
import com.mdx.repository.PaymentTokenRepository;
import com.mdx.utils.DataMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentTokenServiceImpl implements PaymentTokenService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentTokenServiceImpl.class.getName());
    private final PaymentTokenRepository paymentTokenRepository;
    private final DataMapperUtil dataMapperUtil;

    @Autowired
    public PaymentTokenServiceImpl(final PaymentTokenRepository paymentTokenRepository, final DataMapperUtil dataMapperUtil) {
        this.paymentTokenRepository = paymentTokenRepository;
        this.dataMapperUtil = dataMapperUtil;
    }

    @Override
    @Transactional
    public PaymentToken createPaymentToken(PaymentToken paymentToken) {
        logger.info("createPaymentToken "+ paymentToken);
        Preconditions.checkNotNull(paymentToken);
        Optional<PaymentTokenEntity> opt = Optional.ofNullable(paymentTokenRepository.save(dataMapperUtil.convertModelToEntity(paymentToken)));
        if (!opt.isPresent()) {
            String errorMsg = "Couldn't create entry";
            logger.error(errorMsg);
            throw new ObjectNotFoundException(errorMsg);
        }
        return dataMapperUtil.convertEntityToModel(opt.get());
    }

    @Override
    public PaymentToken getPaymentToken(final Long tokenReferenceId, final String tokenRequesterId) {
        logger.info("getPaymentToken");
        Preconditions.checkNotNull(tokenReferenceId);
        Preconditions.checkNotNull(tokenRequesterId);
        Optional<PaymentTokenEntity> opt = paymentTokenRepository.findByTokenReferenceIdAndTokenRequesterId(tokenReferenceId, tokenRequesterId);

        if (!opt.isPresent()) {
            String errorMsg = "Couldn't find entry";
            logger.error(errorMsg);
            throw new ObjectNotFoundException(errorMsg);
        }
        return dataMapperUtil.convertEntityToModel(opt.get());
    }

    @Override
    public List<Reward> getRewards(final Long tokenReferenceId, final String tokenRequesterId) {
        logger.info("getRewards");
        Preconditions.checkNotNull(tokenReferenceId);
        Preconditions.checkNotNull(tokenRequesterId);
        Optional<PaymentTokenEntity> opt = paymentTokenRepository.findByTokenReferenceIdAndTokenRequesterId(tokenReferenceId, tokenRequesterId);
        if (!opt.isPresent()) {
            String errorMsg = "Couldn't find entry";
            logger.error(errorMsg);
            throw new ObjectNotFoundException(errorMsg);
        }
        //return  opt.get();
        return null;
    }
}


