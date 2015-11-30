package com.eretailer.discount;

public  class PercentageDiscount implements Discount {


	protected final double discountPercentage;
	

	protected PercentageDiscount(double discount){
		this.discountPercentage=discount;
	}
	
	
	public double calculateDiscount(double amount) {
		return amount-=(amount*discountPercentage);
	}

	
	
	public double getDiscountPercentage(){
		return this.discountPercentage;
	}
	
	
	
}
