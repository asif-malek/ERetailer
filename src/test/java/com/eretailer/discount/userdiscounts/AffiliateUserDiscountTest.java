package com.eretailer.discount.userdiscounts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AffiliateUserDiscountTest {

AffiliateUserDiscount ad;
	
	@Before
	public void setup(){
		ad=new AffiliateUserDiscount();
	}
	
	@Test
	public void canCalculateEmployeeDiscount(){
		assertEquals(new Double(90.00),new Double(ad.calculateDiscount(100)));
	}
	
	@Test
	public void hasPercentageDiscount(){
		assertEquals(new Double(0.10),new Double(ad.getDiscountPercentage()));
	}

}
