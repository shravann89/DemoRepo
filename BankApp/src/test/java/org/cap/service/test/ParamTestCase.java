package org.cap.service.test;


import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamTestCase {
	
	private AcccountService accService;

	
	private int[] input;
	private int output2;


	public ParamTestCase(int[] input,int output2) {
		this.input = input;
		this.output2 = output2;
	}
	
	@Parameters
	public static List<Object[]> myParams(){
		return Arrays.asList(new Object[][]{
			{new int[]{4,3},7},
			{new int[]{1,5,8},14}
			
		});
	}
	
	
	@Test
	public void test_Add_SumOfArrays() {
		accService=new AccountServiceImpl();
		Assert.assertEquals(output2,accService.sumOfArray(input));
	}
	
	
	

}
