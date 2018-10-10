package com.mc.demo.app.accounts.model;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public Customer getCustomerBycustid(String custid);
}
