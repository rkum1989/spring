package com.springboot.data.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.data.example.dao.ApiRequestDao;
import com.springboot.data.example.domain.ApiRequest;

@Transactional
@Service
public class ApiRequestService {

	@Autowired
	private ApiRequestDao apiRequestDao;

	public void create(ApiRequest apiRequest) {
		apiRequestDao.create(apiRequest);
	}

	public List<ApiRequest> getApiRequestDetails() {
		List<ApiRequest> response = apiRequestDao.getApiRequestDetails();

		return response;
	}
}
