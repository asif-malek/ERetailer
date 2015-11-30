package com.eretailer.discount.userdiscounts;

import com.eretailer.discount.PercentageDiscount;

public class EmployeeDiscount extends PercentageDiscount {

	private static final double DISCOUNT = 0.3;

	public EmployeeDiscount() {
		super(DISCOUNT);
	}
	
	
	
}
