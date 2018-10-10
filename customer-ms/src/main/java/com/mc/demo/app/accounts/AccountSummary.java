package com.mc.demo.app.accounts;

import java.util.List;

public class AccountSummary {

	private String customerID;
	private String firstName;
	private String lastName;
	private String ssn;
	private String dateofbirth;
	private String MMN;
	private String bankCustNumber;
	private String previousBankAccNumber;
	Address AddressObject;
	private List<Creditcard> creditcardsList;

	// Getter Methods

	/**
	 * @return the creditcardsList
	 */
	public List<Creditcard> getCreditcardsList() {
		return creditcardsList;
	}

	/**
	 * @param creditcardsList
	 *            the creditcardsList to set
	 */
	public void setCreditcardsList(List<Creditcard> creditcardsList) {
		this.creditcardsList = creditcardsList;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public String getMMN() {
		return MMN;
	}

	public String getBankCustNumber() {
		return bankCustNumber;
	}

	public String getPreviousBankAccNumber() {
		return previousBankAccNumber;
	}

	public Address getAddress() {
		return AddressObject;
	}

	// Setter Methods

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public void setMMN(String MMN) {
		this.MMN = MMN;
	}

	public void setBankCustNumber(String bankCustNumber) {
		this.bankCustNumber = bankCustNumber;
	}

	public void setPreviousBankAccNumber(String previousBankAccNumber) {
		this.previousBankAccNumber = previousBankAccNumber;
	}

	public void setAddress(Address addressObject) {
		this.AddressObject = addressObject;
	}

}
