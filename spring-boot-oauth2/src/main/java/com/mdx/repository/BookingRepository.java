////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: BookingRepository.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2018 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mdx.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {
	
}
