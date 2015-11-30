package com.eretailer.discount.userdiscounts;

import com.eretailer.discount.PercentageDiscount;

public class LoyalCustomerDiscount extends PercentageDiscount{

	private static final double DISCOUNT = 0.05;

	public LoyalCustomerDiscount() {
		super(DISCOUNT);
	}
}
