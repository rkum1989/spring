////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: PaymentTokenEntity.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class PaymentTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenReferenceId;

    @NotNull
    @Size(max = 50)
    private String tokenRequesterId;

    @NotNull
    @Size(max = 50)
    private String tokenNumber;

    @NotNull
    private Date tokenExpiryDate;

    @NotNull
    @Size(max = 50)
    private String panSource;

    @NotNull
    @Size(max = 50)
    private String deviceId;


    public Long getTokenReferenceId() {
        return tokenReferenceId;
    }

    public void setTokenReferenceId(final Long tokenReferenceId) {
        this.tokenReferenceId = tokenReferenceId;
    }

    public String getTokenRequesterId() {
        return tokenRequesterId;
    }

    public void setTokenRequesterId(final String tokenRequestorId) {
        this.tokenRequesterId = tokenRequestorId;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public Date getTokenExpiryDate() {
        return new Date(tokenExpiryDate.getTime());
    }

    public void setTokenExpiryDate(Date tokenExpiryDate) {
        this.tokenExpiryDate = new Date(tokenExpiryDate.getTime());
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
