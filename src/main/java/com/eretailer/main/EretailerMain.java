package com.eretailer.main;

import static org.junit.Assert.assertEquals;

import com.eretailer.bill.Bill;
import com.eretailer.bill.DiscountProcessor;
import com.eretailer.products.Grocery;
import com.eretailer.products.NonGrocery;
import com.eretailer.products.Product;
import com.eretailer.users.EmployeeCustomer;

public class EretailerMain {

	public static void main(String[] args) {
		Bill bill=new Bill(new EmployeeCustomer());
		NonGrocery ng=new NonGrocery();
		ng.setAmount(100);
		ng.setName("Dish");
		
		NonGrocery ng2=new NonGrocery();
		ng2.setAmount(100);
		ng2.setName("Tray");
	

		Grocery g2=new Grocery();
		g2.setAmount(100);
		g2.setName("Sugar");
		
		Grocery g=new Grocery();
		g.setAmount(100);
		g.setName("Flour");
	bill.add(ng);
	bill.add(ng2);
	bill.add(g);
	bill.add(g2);
	
	DiscountProcessor dp=new DiscountProcessor();
	dp.processFinalAmountOnBill(bill);
	
	System.out.println("Bill Detail:");

	for(Product p:bill.getProducts()){
	    System.out.println(p.getName() +":"+p.getAmount());
	}
	
	System.out.println("\n\nTotalBill:"+bill.getTotalAmount());
	System.out.println("\n\nTotalBillAfterDiscount:"+bill.getAmountAfterDiscount());


	}

}
