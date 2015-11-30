package com.eretailer.discount.userdiscounts;

import com.eretailer.discount.PercentageDiscount;

public class AffiliateUserDiscount extends PercentageDiscount {
	private static final double DISCOUNT = 0.1;

	public AffiliateUserDiscount() {
		super(DISCOUNT);
	}
}
