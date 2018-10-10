package com.mc.demo.app.redeem.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mc.demo.app.redeem.RedemptionTransaction;

public interface RedemptionService {
	
	public boolean save(RedemptionTransaction transcation);
	
	@Query("SELECT * FROM Redemptiontransaction r where r.redeemid = :cardnumber")
	public List<RedemptionTransaction> getHistoryByCard(@Param("cardnumber") String cardnumber);
	
	@Query("SELECT * FROM Redemptiontransaction r where r.custid = :custId")
	public List<RedemptionTransaction> getHistoryByCustomerID(@Param("custId") String custId);

}
