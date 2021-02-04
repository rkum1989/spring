////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: Reward.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.model;

import java.time.Instant;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Reward {

	// [ data-members]
	@NotNull
	private double points;
	
	@NotNull
	private Instant expiry;
	
	public double getPoints() {
		return points;
	}
	
	public void setPoints(double points) {
		this.points = points;
	}
	
	public Instant getExpiry() {
		return expiry;
	}
	
	public void setExpiry(Instant expiry) {
		this.expiry = expiry;
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
