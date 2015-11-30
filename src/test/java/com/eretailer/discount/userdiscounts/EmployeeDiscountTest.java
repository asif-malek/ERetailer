package com.eretailer.discount.userdiscounts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeDiscountTest {

	EmployeeDiscount ed;
	
	@Before
	public void setup(){
		ed=new EmployeeDiscount();
	}
	
	@Test
	public void canCalculateEmployeeDiscount(){
		assertEquals(new Double(70.00),new Double(ed.calculateDiscount(100)));
	}
	
	@Test
	public void hasPercentageDiscount(){
		assertEquals(new Double(0.30),new Double(ed.getDiscountPercentage()));
	}

}
