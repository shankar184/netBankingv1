package com.inetbanking.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetbanking.pageobjects.Loginpage;

public class TC_loginTest_001 extends Baseclass {
	
	@Test
	public void loginTest() {
		
		//logger.info("url is opened");
		
		Loginpage lp=new Loginpage(driver);
		lp.setusername(username);
		//logger.info("entered username");
		lp.setpassword(password);
		//logger.info("entered password");
		lp.clicksubmit();
		
//		if(driver.getTitle().equals("Guru99 Bank Manager Homepage")) {
//			Assert.assertTrue(true);
		//logger.info("login test passed");
//		}
//		else
//			Assert.assertTrue(false);
		//login.info("login test failed");
		 
		
	}

}
