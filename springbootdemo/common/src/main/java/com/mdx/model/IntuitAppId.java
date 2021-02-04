////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: IntuitAppId.java
//  @Author: Shekhar Cambam
//
//	CONFIDENTIAL -- Copyright 2018 MdxDev. 
//	This is confidential and proprietary information of Mdx Dev.
//	Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.model;

import com.mdx.exception.InvalidFieldException;

public enum IntuitAppId {
	
	ADMIN_PLATFORM("AdminPlatform"), 
	CC("cc"),
	SDP("SDP"),
	USP_SERVER("USPServer");

	private final String value;

	// private-constructor
	private IntuitAppId(String value) {
		this.value = value;
	}

	// value()-method
	public String value() {
		return value;
	}

	// fromString()-method
	public static IntuitAppId fromString(String text) {
		if (text != null) {
			for (IntuitAppId b : IntuitAppId.values()) {
				if (text.equalsIgnoreCase(b.value)) {
					return b;
				}
			}
		}
		throw new InvalidFieldException("externalId.idType", text);
	}
	
} // [ end-of IntuitAppId object.]
