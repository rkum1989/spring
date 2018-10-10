package com.mc.demo.app.accounts.model;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {



	@Id 
	private String custid;
	private String firstname;
	private String lastname;
	private String addressline1;
	private String addressline2;
	private String ssn;	
	private Date dob;
	private String mmn;
	private String bankcustomernumber;
	private String previous_bcn;
	private String zipcode;
	private String state;
	private String city;	
	private String ica_code;
	private String sys_cust_id;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	/**
	 * @return the custid
	 */
	public String getCustid() {
		return custid;
	}
	/**
	 * @param custid the custid to set
	 */
	public void setCustid(String custid) {
		this.custid = custid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the addressline1
	 */
	public String getAddressline1() {
		return addressline1;
	}
	/**
	 * @param addressline1 the addressline1 to set
	 */
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	/**
	 * @return the addressline2
	 */
	public String getAddressline2() {
		return addressline2;
	}
	/**
	 * @param addressline2 the addressline2 to set
	 */
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the mmn
	 */
	public String getMmn() {
		return mmn;
	}
	/**
	 * @param mmn the mmn to set
	 */
	public void setMmn(String mmn) {
		this.mmn = mmn;
	}
	/**
	 * @return the bankcustomernumber
	 */
	public String getBankcustomernumber() {
		return bankcustomernumber;
	}
	/**
	 * @param bankcustomernumber the bankcustomernumber to set
	 */
	public void setBankcustomernumber(String bankcustomernumber) {
		this.bankcustomernumber = bankcustomernumber;
	}
	/**
	 * @return the previous_bcn
	 */
	public String getPrevious_bcn() {
		return previous_bcn;
	}
	/**
	 * @param previous_bcn the previous_bcn to set
	 */
	public void setPrevious_bcn(String previous_bcn) {
		this.previous_bcn = previous_bcn;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the ica_code
	 */
	public String getIca_code() {
		return ica_code;
	}
	/**
	 * @param ica_code the ica_code to set
	 */
	public void setIca_code(String ica_code) {
		this.ica_code = ica_code;
	}
	/**
	 * @return the sys_cust_id
	 */
	public String getSys_cust_id() {
		return sys_cust_id;
	}
	/**
	 * @param sys_cust_id the sys_cust_id to set
	 */
	public void setSys_cust_id(String sys_cust_id) {
		this.sys_cust_id = sys_cust_id;
	}
	/**
	 * @return the created_at
	 */
	public Timestamp getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}

