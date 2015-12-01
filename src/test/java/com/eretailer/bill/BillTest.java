package com.eretailer.bill;

import static org.junit.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

import com.eretailer.products.Grocery;
import com.eretailer.products.NonGrocery;
import com.eretailer.products.Product;
import com.eretailer.users.AffilateCustomer;
import com.eretailer.users.Customer;
import com.eretailer.users.EmployeeCustomer;


public class BillTest {

	Bill b;

	
	@Before
	public void setUp(){
		Customer c= new Customer();
		 b=new Bill(c);
	}
	
	
	@Test
	public void itemCanBeAddedToBill() {
		
		String val = "grocery";
		b.add(createProduct(val));
		b.add(createProduct(val));
		assertEquals(2, b.getProducts().size());
	}
	
	@Test
	public void differntTypesOfItemCanBeAddedToBill() {
		
		String val = "10";
		b.add(createProduct("grocery"));
		b.add(createProduct("NonGrocery"));
		assertEquals(2, b.getProducts().size());
	}

	@Test
	public void processDiscountOnBillTest() {
		
		
	b.add(createProduct("grocery"));
	b.add(createProduct("NonGrocery"));
	b.processDiscountOnBill();
		assertEquals(new Double(190), new Double(b.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(b.getTotalAmount()));
	}
	
	@Test
	public void processDiscountOnBillTestForEmployee() {
		b.setCustomer(new EmployeeCustomer());
		b.add(createProduct("grocery"));
		b.add(createProduct("NonGrocery"));

	b.processDiscountOnBill();
		assertEquals(new Double(165), new Double(b.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(b.getTotalAmount()));
	}
	
	
	@Test
	public void processDiscountOnBillTestForAffiliateCustomer() {
		b.setCustomer(new AffilateCustomer());
		b.add(createProduct("grocery"));
		b.add(createProduct("NonGrocery"));

	b.processDiscountOnBill();
		assertEquals(new Double(185), new Double(b.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(b.getTotalAmount()));
	}
	
	
	
	private Product createProduct(String val) {
		if(val.equals("grocery")){
			Grocery g= new Grocery();
			g.setName("grocery ");
			g.setAmount(100);
			return g;
		}else{
			NonGrocery g= new NonGrocery();
			g.setName("grocery ");
			g.setAmount(100);
			return g;
		}
		
	}
}
