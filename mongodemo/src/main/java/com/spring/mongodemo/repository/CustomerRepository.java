package com.spring.mongodemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.mongodemo.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    
    public List<Customer> findByLastName(String lastName);
    
  /*//Supports native JSON query string
    @Query("{domain:'?0'}")
    Customer findCustomByDomain(String domain);*/

    @Query("{domain: { $regex: ?0 } })")
    List<Customer> findCustomerByRegExpression(String regex);

}
