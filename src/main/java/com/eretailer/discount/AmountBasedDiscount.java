package com.eretailer.discount;

public class AmountBasedDiscount implements Discount {


	private double discountOnAmount;
	
    

	
	
	public double calculateDiscount(double amount) {
		
	
		 this.discountOnAmount=(((amount-(amount%100))/100))*5;
		
		return amount-=this.discountOnAmount;
	}





	public double getDiscountOnAmount() {
		return discountOnAmount;
	}





	public void setDiscountOnAmount(double discountOnAmount) {
		this.discountOnAmount = discountOnAmount;
	}









	
	
	
	
}
	
	