package com.eretailer.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eretailer.discount.PercentageDiscount;

public class PercentageDiscountTest {

	PercentageDiscount p;
	
	

	@Before
	public void setup(){
		 p=new PercentageDiscount(0.10);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void discountCanCalculate(){
		
		assertEquals(new Double(90.00),new Double(p.calculateDiscount(100)));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void discountHasPercentage(){
		
		assertEquals(new Double(0.1),new Double(p.getDiscountPercentage()));
	}
	
}
