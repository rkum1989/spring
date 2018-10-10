package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "customer")
public class Customer {
	
	@JsonProperty("customerId")
	@NotNull
	@Size(min = 1, max = 5, message = "customerId length should be min 1 max 5 ")
	private String customerId;
	
	@NotNull
	@Size(min = 6, max = 30, message = "customerId length should be min 6 max 30 ")
	@JsonProperty("name")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 2, message = "customerId length should be min 10 max 60 ")
	@JsonProperty("address")
	private List<String> address;
	
	@DecimalMin(value = "1.00", message="customerAccountBalanceMin should be min 1.00 ")
	private BigDecimal customerAccountBalanceMin;
	
	@DecimalMax(value = "99.00", message ="customerAccountBalanceMax should be max 99.00 ")
	private BigDecimal customerAccountBalanceMax;
	
	@Digits(integer=5, fraction=3, message= "customerAccountBalance should be in range of integer=5, fraction=3 ")
	private BigDecimal customerAccountBalance;
	
	@Past(message= "customerAccountCreationDate should be a past date")
	private Date customerAccountCreationDate;
	
	@Future(message="customerAccountExpiryDate should be a future date")
	private Date customerAccountExpiryDate;
	
	@Pattern(regexp= "\\(\\d{3}\\)\\d{3}-\\d{4}", message="customerPhoneNumberPattern should match the pattern")
	private String customerPhoneNumberPattern;

	private Map<String, String> properties;
	
	@JsonRawValue
    public String json;
	
	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public BigDecimal getCustomerAccountBalanceMin() {
		return customerAccountBalanceMin;
	}

	public void setCustomerAccountBalanceMin(BigDecimal customerAccountBalanceMin) {
		this.customerAccountBalanceMin = customerAccountBalanceMin;
	}

	public BigDecimal getCustomerAccountBalanceMax() {
		return customerAccountBalanceMax;
	}

	public void setCustomerAccountBalanceMax(BigDecimal customerAccountBalanceMax) {
		this.customerAccountBalanceMax = customerAccountBalanceMax;
	}

	public BigDecimal getCustomerAccountBalance() {
		return customerAccountBalance;
	}

	public void setCustomerAccountBalance(BigDecimal customerAccountBalance) {
		this.customerAccountBalance = customerAccountBalance;
	}

	public Date getCustomerAccountCreationDate() {
		return customerAccountCreationDate;
	}

	public void setCustomerAccountCreationDate(Date customerAccountCreationDate) {
		this.customerAccountCreationDate = customerAccountCreationDate;
	}

	public Date getCustomerAccountExpiryDate() {
		return customerAccountExpiryDate;
	}

	public void setCustomerAccountExpiryDate(Date customerAccountExpiryDate) {
		this.customerAccountExpiryDate = customerAccountExpiryDate;
	}

	public String getCustomerPhoneNumberPattern() {
		return customerPhoneNumberPattern;
	}

	public void setCustomerPhoneNumberPattern(String customerPhoneNumberPattern) {
		this.customerPhoneNumberPattern = customerPhoneNumberPattern;
	}
}
