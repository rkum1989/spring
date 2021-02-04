////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: Booking.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import static java.lang.String.format;

@Entity
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 2570388667799620568L;
	
    @Id
    @Column(updatable = false, nullable = false)
    @Size(min = 0, max = 50)
	private String bookingCode;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        if (!bookingCode.equals(booking.bookingCode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return bookingCode.hashCode();
    }

    @Override 
    public String toString() {
        return format("Ride confirmed: code '%s'.", bookingCode);
    }

}
