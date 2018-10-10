/**
 * 
 */
package com.mc.demo.app.redeem;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wipro
 *
 */
public class RedemptionTransaction {

	@NotEmpty(message = "CustomerId is required")
	private String custid;
	
	@JsonProperty(value = "cardnumber", required = true)
	@NotEmpty(message = "CardNumber is required")
	private String cardNumber;
	
	@PositiveOrZero(message = "RedeemedPoints is required")
	private double redeemedpoints;
	
	@NotEmpty(message = "ItemQuantity is required")
	private String quantity;
	
	private Timestamp redemptiontimestaamp;
	
	@NotEmpty(message = "RedeemedItem is required")
	private String redeemeditem;
	
	@NotEmpty(message = "vendorId is required")
	private String vendorid;
	
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
	 * @return the redeemedpoints
	 */
	public double getRedeemedpoints() {
		return redeemedpoints;
	}
	/**
	 * @param redeemedpoints the redeemedpoints to set
	 */
	public void setRedeemedpoints(double redeemedpoints) {
		this.redeemedpoints = redeemedpoints;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the redemptiontimestaamp
	 */
	public Timestamp getRedemptiontimestaamp() {
		return redemptiontimestaamp;
	}
	/**
	 * @param redemptiontimestaamp the redemptiontimestaamp to set
	 */
	public void setRedemptiontimestaamp(Timestamp redemptiontimestaamp) {
		this.redemptiontimestaamp = redemptiontimestaamp;
	}
	/**
	 * @return the redeemeditem
	 */
	public String getRedeemeditem() {
		return redeemeditem;
	}
	/**
	 * @param redeemeditem the redeemeditem to set
	 */
	public void setRedeemeditem(String redeemeditem) {
		this.redeemeditem = redeemeditem;
	}
	/**
	 * @return the vendorid
	 */
	public String getVendorid() {
		return vendorid;
	}
	/**
	 * @param vendorid the vendorid to set
	 */
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
