package com.inetbanking.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.netbanking.utilities.XLUTils;


public class TC_LoginDDT_002 extends Baseclass {
	
	@Test(dataProvider="LoginData")
	public void LoginDDt(String user,String pwd) throws InterruptedException {
     
		Loginpage lp=new Loginpage(driver);
		lp.setusername(user);
		lp.setpassword(pwd);
		lp.clicksubmit();
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			}
		else
		{Assert.assertTrue(true);
		lp.clicklogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close the logout alert
		driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()//user defined method to check whether the alert is present or not. 
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="un_pwd")
	String[][] getData() throws IOException{
		String path="C://HYBRID FRAMEWORK//netbankingv1//src//test//java//com//netbanking//testData//un_pwd.xlsx";
		int rownum=XLUTils.getrowcount(path, "sheet1");
		int colcount=XLUTils.getcellcount(path, "sheet1", 1);
		
		String un_pwd[][]=new String[rownum][colcount];
		for (int i = 1; i <rownum ; i++) {
			for (int j = 0; j < colcount; j++) {
				un_pwd[i-1][j]=XLUTils.getcellData(path,"sheet1", i, j);
				}
		}
		return un_pwd;
		}
	}
