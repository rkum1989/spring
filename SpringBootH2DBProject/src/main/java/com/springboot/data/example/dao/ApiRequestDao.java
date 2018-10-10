package com.springboot.data.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springboot.data.example.domain.ApiRequest;

@Repository
public class ApiRequestDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(ApiRequest apiRequest) {
		entityManager.persist(apiRequest);
	}

	public void update(ApiRequest apiRequest) {
		entityManager.merge(apiRequest);
	}

	public ApiRequest getApiRequestById(long id) {
		return entityManager.find(ApiRequest.class, id);
	}

	public List<ApiRequest> getApiRequestDetails() {
		String hql = "FROM ApiRequest as api";
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ApiRequest> result = query.getResultList();
		return result;
	}

	public void delete(long id) {
		ApiRequest apiRequest = getApiRequestById(id);
		if (apiRequest != null) {
			entityManager.remove(apiRequest);
		}
	}
}
