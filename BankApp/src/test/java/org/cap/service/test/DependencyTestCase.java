package org.cap.service.test;


import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DependencyTestCase {

	@Mock
	private AccountDao accountDao;
	private AcccountService accountService;
	
	
	//Declaration
	
	
	@Test
	public void test_deposit_withMock() {
		
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
		Customer c = new Customer();
		c.setCustName("Tom");
		c.setCustAddress(new Address());
		
		Account acc = new Account();
		acc.setAccountNo(1221);
		acc.setCustomer(c);
		acc.setAmount(1500);

		//DEclaration
		
		Mockito.when(accountDao.findAccountById(1221)).thenReturn(acc);
		
		
		//Actual logic
		Account depositAccount = accountService.deposit(1221, 1800);
		
		
		Mockito.verify(accountDao).findAccountById(1221);
          Assert.assertEquals(3300.0,depositAccount.getAmount(),0.0);
	}
	
	

}
