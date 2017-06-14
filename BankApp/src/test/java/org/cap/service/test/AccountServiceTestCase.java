package org.cap.service.test;

import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceTestCase {
	
	private AcccountService accountService;
	
	@Before
	public void setUp() {
		System.out.println("Testing setupppppp");
		accountService = new AccountServiceImpl();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_addAccount_with_nullCustomer() throws InvalidInitialAmountException{
		Customer customer=null;
		accountService.addAccount(customer, 1500);
	}
	
	
	@Test(timeout=1)
	public void test_loop_timeOut() {
		accountService.myLoop();
	}

}
