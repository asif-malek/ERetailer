package com.eretailer.bill;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eretailer.discount.AmountBasedDiscountTest;
import com.eretailer.discount.PercentageDiscount;
import com.eretailer.discount.PercentageDiscountTest;
import com.eretailer.discount.userdiscounts.AffiliateUserDiscountTest;
import com.eretailer.discount.userdiscounts.EmployeeDiscountTest;
import com.eretailer.discount.userdiscounts.LoyalCustomerDiscount;
import com.eretailer.discount.userdiscounts.LoyalCustomerDiscountTest;
import com.eretailer.users.CustomerTest;

@RunWith(Suite.class)
@SuiteClasses({ BillTest.class, 
	DiscountProcessorTest.class,
	AmountBasedDiscountTest.class,
	PercentageDiscountTest.class,
	AffiliateUserDiscountTest.class,
	EmployeeDiscountTest.class,
	LoyalCustomerDiscountTest.class,
	CustomerTest.class})

public class AllTests {

}
