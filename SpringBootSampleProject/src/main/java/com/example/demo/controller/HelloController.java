package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.User;

@RestController
@RequestMapping(path="/hello")
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(path="/v1/hello", consumes="application/json", produces="application/json",method=RequestMethod.GET)
	public String sayHello(){
		logger.info("sayHello()");
		return "Hello SpringBoot World!";
	}
	
	@RequestMapping(path="/v1/create", consumes="application/json", produces="application/json",method=RequestMethod.POST)
	public ResponseEntity<?> createCustomerEntry(@Validated @RequestBody CustomerModel customer){
		logger.info("createCustomerEntry()");
		
		return new ResponseEntity<>(customer.getCustomer(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getuser", method=RequestMethod.GET)
    public User getUser() {
		logger.info("getUser");
		return new User(1,"jsaxnlsa");
    }

    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {    	
    	return null;
    }

    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
		return new User();
    }
}
