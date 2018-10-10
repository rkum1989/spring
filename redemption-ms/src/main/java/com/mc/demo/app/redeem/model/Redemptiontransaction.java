package com.mc.demo.app.redeem.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Redemptiontransaction {
	
	
	@Id
	private String redeemid;
	
	private String custid;
	private String accountnumber;
	private double redeemedpoints;
	private String quantity;
	private Timestamp redemptointimestaamp; 
	private String redeemeditem;
	private String vendorid;
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
	 * @return the redeemid
	 */
	public String getRedeemid() {
		return redeemid;
	}
	/**
	 * @param redeemid the redeemid to set
	 */
	public void setRedeemid(String redeemid) {
		this.redeemid = redeemid;
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
	/**
	 * @return the redemptointimestaamp
	 */
	public Timestamp getRedemptointimestaamp() {
		return redemptointimestaamp;
	}
	/**
	 * @param redemptointimestaamp the redemptointimestaamp to set
	 */
	public void setRedemptointimestaamp(Timestamp redemptointimestaamp) {
		this.redemptointimestaamp = redemptointimestaamp;
	}
	
	
	
	
}
