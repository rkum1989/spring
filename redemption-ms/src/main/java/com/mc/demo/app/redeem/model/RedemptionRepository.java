package com.mc.demo.app.redeem.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RedemptionRepository extends CrudRepository<Redemptiontransaction, Integer> {
	
	public List<Redemptiontransaction> findRedeemHistoryByCustid(String custid);
	
	public List<Redemptiontransaction> findRedeemHistoryByAccountnumber(String accountnumber);
}
