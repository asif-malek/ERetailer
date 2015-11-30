package com.eretailer.users;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Customer {

	Date firstPurchaseDate;

	public Customer(){
		this.firstPurchaseDate=new Date();
	}
	public Date getFirstPurchaseDate() {
		return firstPurchaseDate;
	}

	public void setFirstPurchaseDate(Date firstPurchaseDate) {
		this.firstPurchaseDate = firstPurchaseDate;
	}
	
    @SuppressWarnings("deprecation")
	public int getNoOfYears(){
    	return new Date().getYear()-this.firstPurchaseDate.getYear();
    	
        
    }
    
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
