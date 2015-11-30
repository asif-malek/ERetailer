package com.eretailer.users;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	Customer c;
	
	
	@Before
	public void setup(){
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
	}
	
	@Test
	public void customerHasLoyaltyYears() {
		assertEquals(3,c.getNoOfYears());
	}

}
