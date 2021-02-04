package com.mc.demo.app.accounts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.demo.app.accounts.AccountSummary;
import com.mc.demo.app.accounts.Address;
import com.mc.demo.app.accounts.Creditcard;
import com.mc.demo.app.accounts.exception.ObjectNotFoundException;
import com.mc.demo.app.accounts.model.Account;
import com.mc.demo.app.accounts.model.AccountRepository;
import com.mc.demo.app.accounts.model.Customer;
import com.mc.demo.app.accounts.model.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accRepo;

	@Autowired
	CustomerRepository custRepo;

	@Override
	public AccountSummary getAccountSummary(String cardnumber) {

		AccountSummary accountSummary = new AccountSummary();

		Account account = accRepo.findByAccountnumber(cardnumber);

		if (account == null) {
			throw new ObjectNotFoundException("No Record found");
		}
		
		String custid = account.getCustid();
		Customer customer = custRepo.getCustomerBycustid(custid);
		accountSummary.setCustomerID(custid);
		List<Creditcard> creditcardList = new ArrayList<Creditcard>();
		List<Account> accounts = accRepo.findByCustid(custid);
		accounts.forEach(accnt -> {
			Creditcard ccard = new Creditcard();
			ccard.setCredicardnumber(accnt.getAccountnumber());
			ccard.setAccountStatusID(accnt.getAccountstatusid());
			ccard.setBankProductcode(accnt.getBankprdcode());
			ccard.setCardType(accnt.getAccounttype());
			ccard.setPointsTotal(accnt.getPointsaccured());
			ccard.setProgramID(accnt.getProgramid());
			creditcardList.add(ccard);
		});
		accountSummary.setCreditcardsList(creditcardList);
		accountSummary.setDateofbirth(customer.getDob().toString());
		accountSummary.setBankCustNumber(customer.getBankcustomernumber());
		accountSummary.setFirstName(customer.getFirstname());
		accountSummary.setLastName(customer.getLastname());
		accountSummary.setMMN(customer.getMmn());

		Address address = new Address();
		address.setAddress1(customer.getAddressline1());
		address.setAddress2(customer.getAddressline2());
		address.setCity(customer.getCity());
		address.setState(customer.getState());
		address.setZipCode(customer.getZipcode());

		accountSummary.setAddress(address);
		return accountSummary;
	}

}
