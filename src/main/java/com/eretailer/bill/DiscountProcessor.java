package com.eretailer.bill;

import com.eretailer.discount.AmountBasedDiscount;
import com.eretailer.discount.Discount;
import com.eretailer.discount.PercentageDiscount;
import com.eretailer.discount.userdiscounts.AffiliateUserDiscount;
import com.eretailer.discount.userdiscounts.EmployeeDiscount;
import com.eretailer.discount.userdiscounts.LoyalCustomerDiscount;
import com.eretailer.products.NonGrocery;
import com.eretailer.products.Product;
import com.eretailer.users.AffilateCustomer;
import com.eretailer.users.Customer;
import com.eretailer.users.EmployeeCustomer;


/**
 * 
 * @author asimalek
 *This class is reponsible for applying right discount at right place
 */
public class DiscountProcessor {

	
	 public double processFinalAmountOnBill(Bill bill){
		
		proceessBillTotal(bill);
		 
	
		
		prcoessPercentageDiscountOverBillItems(bill);
		prcoessDiscountOverTotal(bill);
		
		return 0;
	}
	
	 
	 private DiscountProcessor(){}
     
	    private static class SingletonHelper{
	        private static final DiscountProcessor INSTANCE = new DiscountProcessor();
	    }
	     
	    public static DiscountProcessor getInstance(){
	        return SingletonHelper.INSTANCE;
	    }
	 
	 
	 
	 
	/**
	 * 
	 * @param c
	 * @return
	 * 
	 * higest eligible discount will be applied
	 */
	
	 Discount getEligibleCustomerBasedDiscount(Customer c){
		PercentageDiscount  eligibleDiscount=null;
		
		if(c instanceof EmployeeCustomer){
			eligibleDiscount= new EmployeeDiscount();
		}
		
		if(c instanceof AffilateCustomer){
			AffiliateUserDiscount af=new AffiliateUserDiscount();
			
			
			if(eligibleDiscount==null){
				eligibleDiscount=af;
			}else if(af.getDiscountPercentage()>eligibleDiscount.getDiscountPercentage()){
				eligibleDiscount=af;
			}
		}
		
		if(c instanceof Customer){
			
			if(c.getNoOfYears()>2){
				LoyalCustomerDiscount cd=new LoyalCustomerDiscount();
				
				if(eligibleDiscount==null){
					eligibleDiscount=cd;
				}else if(cd.getDiscountPercentage()>eligibleDiscount.getDiscountPercentage()){
					eligibleDiscount=cd;
				}
			}
			
		}
		 
		 
		 return eligibleDiscount;
		
	}


	public void prcoessPercentageDiscountOverBillItems(Bill bill) {
		
		Discount discount=getEligibleCustomerBasedDiscount(bill.getCustomer());
		double discountedBill=0;
		for(Product p:bill.getProducts()){
			if(p instanceof NonGrocery){
			discountedBill+=discount.calculateDiscount( p.getAmount());
			}
			else{
				discountedBill+= p.getAmount();
			}
		}
		bill.setAmountAfterDiscount(discountedBill);
		
		
	}
	
	public void proceessBillTotal(Bill bill){
		
		double totalBillAmount=0;
		for(Product p:bill.getProducts()){
			
			totalBillAmount+= p.getAmount();
			
		}
		
		bill.setTotalAmount(totalBillAmount);	
		
	}

	public void prcoessDiscountOverTotal(Bill bill) {
		
		Discount discount=new AmountBasedDiscount();
		bill.setAmountAfterDiscount(discount.calculateDiscount(bill.getAmountAfterDiscount()));
		
	}
}
