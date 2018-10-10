package com.mc.demo.app.accounts.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	
	private String custid; 
	@Id
	private String accountnumber; 
	private String bankprdcode; 
	private String programid; 
	private String accountstatusid; 
	private String pointsaccured; 
	private String householdid; 
	private String accounttype; 
	private String created_at; 
	private String updated_at;
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
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}
	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	/**
	 * @return the bankprdcode
	 */
	public String getBankprdcode() {
		return bankprdcode;
	}
	/**
	 * @param bankprdcode the bankprdcode to set
	 */
	public void setBankprdcode(String bankprdcode) {
		this.bankprdcode = bankprdcode;
	}
	/**
	 * @return the programid
	 */
	public String getProgramid() {
		return programid;
	}
	/**
	 * @param programid the programid to set
	 */
	public void setProgramid(String programid) {
		this.programid = programid;
	}
	/**
	 * @return the accountstatusid
	 */
	public String getAccountstatusid() {
		return accountstatusid;
	}
	/**
	 * @param accountstatusid the accountstatusid to set
	 */
	public void setAccountstatusid(String accountstatusid) {
		this.accountstatusid = accountstatusid;
	}
	/**
	 * @return the pointsaccured
	 */
	public String getPointsaccured() {
		return pointsaccured;
	}
	/**
	 * @param pointsaccured the pointsaccured to set
	 */
	public void setPointsaccured(String pointsaccured) {
		this.pointsaccured = pointsaccured;
	}
	/**
	 * @return the householdid
	 */
	public String getHouseholdid() {
		return householdid;
	}
	/**
	 * @param householdid the householdid to set
	 */
	public void setHouseholdid(String householdid) {
		this.householdid = householdid;
	}
	/**
	 * @return the accounttype
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * @param accounttype the accounttype to set
	 */
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	

}

