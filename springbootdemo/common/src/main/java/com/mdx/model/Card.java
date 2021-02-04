////////////////////////////////////////////////////////////////////////////////////////////
// 
// @ID: Card.java
// @Author: Rituraj Kumar
// Date: 4/1/2018.
//
// Purpose:
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Card {
	
	// [ data-members]
	private String securityToken;
    private String panReferenceId;
    
    
    public String getSecurityToken() {
		return securityToken;
	}
    
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}
	
	public String getPanReferenceId() {
		return panReferenceId;
	}
	
	public void setPanReferenceId(String panReferenceId) {
		this.panReferenceId = panReferenceId;
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
