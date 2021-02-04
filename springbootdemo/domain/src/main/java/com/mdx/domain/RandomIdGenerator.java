////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: RandomIdGenerator.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Component
public class RandomIdGenerator implements IdentifierGenerator {
	
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return generateId();
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
