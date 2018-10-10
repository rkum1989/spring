package com.springboot.data.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.data.example.domain.ApiRequest;
import com.springboot.data.example.service.ApiRequestService;

@RestController
public class ApiRequestController {

	@Autowired
	private ApiRequestService apiRequestService;

	private static final Logger logger = LoggerFactory.getLogger(ApiRequestController.class);

	@RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Map<String, String> createApiRequest() {
		logger.info("Api request received for createApiRequest");

		Map<String, String> response = new HashMap<String, String>();
		try {
			ApiRequest apiRequest = new ApiRequest(new Random().nextLong(), new Date());
			apiRequestService.create(apiRequest);
			response.put("status", "success");
		} catch (Exception e) {
			logger.error("Error occurred while trying to process api request", e);
			response.put("status", "fail");
		}

		return response;
	}

	@RequestMapping(value = "/getApiRequestDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> getApiRequest() {
		logger.info("Api request received for getApiRequest");
		List<ApiRequest> response = null;
		try {
			response = apiRequestService.getApiRequestDetails();
		} catch (Exception e) {
			logger.error("Error occurred while trying to process api request", e);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}