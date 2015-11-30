package com.eretailer.discount.userdiscounts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoyalCustomerDiscountTest {

	LoyalCustomerDiscount ld;
	
	@Before
	public void setup(){
		ld=new LoyalCustomerDiscount();
	}
	
	@Test
	public void canCalculateEmployeeDiscount(){
		assertEquals(new Double(95.00),new Double(ld.calculateDiscount(100)));
	}
	
	@Test
	public void hasPercentageDiscount(){
		assertEquals(new Double(0.05),new Double(ld.getDiscountPercentage()));
	}

}
