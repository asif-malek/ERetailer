package com.eretailer.bill;

import java.util.ArrayList;
import java.util.List;

import com.eretailer.products.Product;
import com.eretailer.users.Customer;

public class Bill {

	private List<Product> products=new ArrayList<Product>();
	
	private Customer customer;
	
	private double totalAmount;
	private double amountAfterDiscount;


	public Bill(Customer customer) {
		super();
		this.customer = customer;
		
	}



	public void add(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
	}



	public List<Product> getProducts() {
		return products;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}



	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	
	
	
	
	
}
