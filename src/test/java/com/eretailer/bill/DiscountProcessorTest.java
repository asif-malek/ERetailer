package com.eretailer.bill;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.eretailer.discount.userdiscounts.AffiliateUserDiscount;
import com.eretailer.discount.userdiscounts.EmployeeDiscount;
import com.eretailer.discount.userdiscounts.LoyalCustomerDiscount;
import com.eretailer.products.Grocery;
import com.eretailer.products.NonGrocery;
import com.eretailer.users.AffilateCustomer;
import com.eretailer.users.Customer;
import com.eretailer.users.EmployeeCustomer;


public class DiscountProcessorTest {

	
	DiscountProcessor dp;
	Customer c;
	Bill bill;
	
	@Before
	public void setUp(){
		
		 dp=DiscountProcessor.getInstance();
		 createBillObjectWithProducts();
	}
	
	

	
	@Test
	public void shouldBeAbletoFetchEmployeeDiscount(){
		c=new EmployeeCustomer();
		EmployeeDiscount ed=(EmployeeDiscount)dp.getEligibleCustomerBasedDiscount(c);
		assertEquals(new Double(new EmployeeDiscount().getDiscountPercentage()),new Double(ed.getDiscountPercentage()));
	}
	
	
	
	@Test
	public void shouldBeAbletoFetchaffiliateCutomerDiscount(){
		c=new AffilateCustomer();
		AffiliateUserDiscount ad=(AffiliateUserDiscount)dp.getEligibleCustomerBasedDiscount(c);
		assertEquals(new Double(new AffiliateUserDiscount().getDiscountPercentage()),new Double(ad.getDiscountPercentage()));
	}
	
	@Test
	public void shouldBeAbletoFetchLoyalCutomerDiscount(){
		c=new Customer();
		c=new Customer();
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate=null;
		try {
			 inputDate = dateFormat.parse(inputStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setFirstPurchaseDate(inputDate);
		LoyalCustomerDiscount ld=(LoyalCustomerDiscount)dp.getEligibleCustomerBasedDiscount(c);
		assertEquals(new Double(new LoyalCustomerDiscount().getDiscountPercentage()),new Double(ld.getDiscountPercentage()));
	}
	
	@Test
	public void shouldBeAbletoPrcoessPercentageDiscountOverBillItems(){
		
		dp.prcoessPercentageDiscountOverBillItems(bill);
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(170.00));
		
	}
	
	@Test
	public void shouldBeAbletoPrcoessDiscountOverTotal(){
		bill=new Bill(new EmployeeCustomer());
		bill.setAmountAfterDiscount(1000);
		dp.prcoessDiscountOverTotal(bill);
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(950.00));
		
	}

	@Test
	public void shouldBeAbletoPrcoessTotal(){
		createBillObjectWithProducts();
		
		dp.proceessBillTotal(bill);
		assertEquals(new Double(bill.getTotalAmount()),new Double(200.00));
		
	}
	

	@Test
	public void ableToMakeFinalPayableAMountForEmployee(){
		
		dp.processFinalAmountOnBill(bill);
		
		assertEquals(new Double(bill.getTotalAmount()),new Double(200.00));
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(165.00));
		
	}
	
	@Test
	public void ableToMakeFinalPayableAMountForLoyalCustomer(){
		Customer loyalCust=new Customer();
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate=null;
		try {
			 inputDate = dateFormat.parse(inputStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		loyalCust.setFirstPurchaseDate(inputDate);
		bill.setCustomer(loyalCust);
		dp.processFinalAmountOnBill(bill);
		
		assertEquals(new Double(bill.getTotalAmount()),new Double(200.00));
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(190.00));
		
	}
	
	

	@Test
	public void ableToMakeFinalPayableAMountForAffiliateCustomer(){
		Customer affCust=new AffilateCustomer();
		bill.setCustomer(affCust);
		
		dp.processFinalAmountOnBill(bill);
		
		assertEquals(new Double(bill.getTotalAmount()),new Double(200.00));
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(185.00));
		
	}
	
	@Test
	public void ableToMakeFinalPayableAMountForGroceries(){
		bill=new Bill(new EmployeeCustomer());
		
		Grocery g1=new Grocery();
		g1.setAmount(200);
		
		Grocery g2=new Grocery();
		g2.setAmount(200);
		
		bill.add(g1);
		bill.add(g2);
		
	
	
		dp.processFinalAmountOnBill(bill);
		
		assertEquals(new Double(bill.getTotalAmount()),new Double(400.00));
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(380.00));
		
	}
	
	
	@Test
	public void ableToMakeFinalPayableAMountForNONGroceries(){
		bill=new Bill(new EmployeeCustomer());
		
		NonGrocery g1=new NonGrocery();
		g1.setAmount(200);
		
		NonGrocery g2=new NonGrocery();
		g2.setAmount(200);
		
		bill.add(g1);
		bill.add(g2);
		
	
	
		dp.processFinalAmountOnBill(bill);
		
		assertEquals(new Double(bill.getTotalAmount()),new Double(400.00));
		assertEquals(new Double(bill.getAmountAfterDiscount()),new Double(270.00));
		
	}
	

	private void createBillObjectWithProducts() {
		bill=new Bill(new EmployeeCustomer());
		NonGrocery ng=new NonGrocery();
		ng.setAmount(100);
		ng.setName("Glue");
		
		Grocery g=new Grocery();
		g.setAmount(100);
		g.setName("Flour");
	bill.add(ng);
	bill.add(g);
	}


}
