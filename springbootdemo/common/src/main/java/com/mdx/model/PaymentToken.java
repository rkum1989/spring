////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: PaymentToken.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.model;


import java.sql.Date;

public final class PaymentToken {

    // [ data-members]
    private String tokenNumber;
    private Date tokenExpiryDate;
    private Long tokenReferenceId;
    private String tokenRequesterId;
    private String panSource;
    private String deviceId;

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
        this.tokenExpiryDate = new Date(tokenExpiryDate.getTime());;
    }

    public Long getTokenReferenceId() {
        return tokenReferenceId;
    }

    public void setTokenReferenceId(Long tokenReferenceId) {
        this.tokenReferenceId = tokenReferenceId;
    }

    public String getTokenRequesterId() {
        return tokenRequesterId;
    }

    public void setTokenRequesterId(String tokenRequesterId) {
        this.tokenRequesterId = tokenRequesterId;
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


}
