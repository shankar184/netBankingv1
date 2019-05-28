package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	
	public Readconfig() {
		File src=new File("C:\\HYBRID FRAMEWORK\\netbankingv1\\Configuaration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			}
		catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
			
		}
	}	
	

	public String getApplicationurl() {
		String url=pro.getProperty("baseUrl");
		return url;
		}
	
	public String getusername() {
	String username=pro.getProperty("username");
	return username;
	}
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
		}
	
	public String chromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		}
	
		
	
}
