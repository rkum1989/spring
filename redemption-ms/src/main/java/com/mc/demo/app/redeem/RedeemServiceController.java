package com.mc.demo.app.redeem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc.demo.app.redeem.exception.ObjectNotFoundException;
import com.mc.demo.app.redeem.service.RedemptionService;

@RestController
@RequestMapping("/v1/api/loyalty/redemption")
public class RedeemServiceController {

	@Autowired
	RedemptionService redeemService;

	@RequestMapping(value = "/savetransaction", method = RequestMethod.POST)
	public String redeemPoints(@RequestBody @Validated RedemptionTransaction redeem,
			@RequestHeader(name = "uuid", required = true) String uuid,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "Accept", required = true) String accept) {

		if (redeemService.save(redeem)) {
			return "succesful";
		}
		return "unsuccessful";
	}

	@RequestMapping(value = "/historybycard/{cardnumber}", method = RequestMethod.GET)
	public ResponseEntity<List<RedemptionTransaction>> getHistorybyCardNumber(@PathVariable String cardnumber,
			@RequestHeader(name = "uuid", required = true) String uuid,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "Accept", required = true) String accept) {
		List<RedemptionTransaction> historyList = redeemService.getHistoryByCard(cardnumber);

		if (null == historyList) {
			throw new ObjectNotFoundException("NO Record Found");
		}
		return new ResponseEntity<List<RedemptionTransaction>>(historyList, HttpStatus.OK);
	}

	@RequestMapping(value = "/historybycustId/{custid}", method = RequestMethod.GET)
	public ResponseEntity<List<RedemptionTransaction>> getHistorybyCustID(@PathVariable(value = "custid") String custId,
			@RequestHeader(name = "uuid", required = true) String uuid,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "Accept", required = true) String accept) {
		List<RedemptionTransaction> historyList = redeemService.getHistoryByCustomerID(custId);

		if (null == historyList) {
			throw new ObjectNotFoundException("NO Record Found");
		}
		return new ResponseEntity<List<RedemptionTransaction>>(historyList, HttpStatus.OK);
	}

}
