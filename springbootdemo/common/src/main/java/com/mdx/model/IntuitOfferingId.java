////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: IntuitOfferingId.java
//  @Author: Shekhar Cambam
//
//	CONFIDENTIAL -- Copyright 2015 Digital Insight. 
//	This is confidential and proprietary information of Digital Insight.
//	Use, reproduction, disclosure and distribution by any means are prohibited,except 
//	pursuant to a written license from Digital Insight. 
//	Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.model;

import com.mdx.exception.InvalidFieldException;

public enum IntuitOfferingId {
	
	ADMIN_PLATFORM("AdminPlatform"), 
	CC("cc"),
	SDP("SDP"),
	USP_SERVER("USPServer");

	private final String value;

	// private-constructor
	private IntuitOfferingId(String value) {
		this.value = value;
	}

	// value()-method
	public String value() {
		return value;
	}

	// fromString()-method
	public static IntuitOfferingId fromString(String text) {
		if (text != null) {
			for (IntuitOfferingId b : IntuitOfferingId.values()) {
				if (text.equalsIgnoreCase(b.value)) {
					return b;
				}
			}
		}
		throw new InvalidFieldException("externalId.idType", text);
	}
	
} // [ end-of IntuitOfferingId object.]
