package com.eretailer.discount;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.eretailer.discount.AmountBasedDiscount;

public class AmountBasedDiscountTest {

	AmountBasedDiscount a;
	
	@Before
	public void setup(){
		a=new AmountBasedDiscount();
		a.setDiscountOnAmount(5);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void discountCanCalculate(){
		
		assertEquals(new Double(95.00),new Double(a.calculateDiscount(100)));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void discountHasDiscountAmount(){
		
		assertEquals(new Double(5),new Double(a.getDiscountOnAmount()));
	}

}
