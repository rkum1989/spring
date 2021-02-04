////////////////////////////////////////////////////////////////////////////////////////
//
// @Id: BookingController.java
// @Author: Shekhar Cambam
//
// CONFIDENTIAL -- Copyright 2016 SpringBootDev.
// This is confidential and proprietary information of SpringBootDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdx.domain.Booking;
import com.mdx.repository.BookingRepository;

@RestController
@RequestMapping(BookingController.API_URL)
public class BookingController {

    public static final String API_URL = "/v1/booking";

    @Autowired
    private BookingRepository bookingRepository;

    @PreAuthorize("#oauth2.hasScope('myapi:write')")
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking patchBooking(OAuth2Authentication authentication, @RequestBody @Valid Booking booking) {
//        String subjectId = MyOAuth2Helper.subjectId(authentication);
//        booking.setSubjectId(subjectId);
    	// bookingCode which is the ID, would be created, as the primary-key
        return bookingRepository.save(booking);
    }
}