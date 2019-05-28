package com.inetbanking.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.netbanking.utilities.Readconfig;




public class Baseclass {
	Readconfig readconfig=new Readconfig();
	
	public String baseUrl=readconfig.getApplicationurl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.chromepath());
			driver=new ChromeDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		// logger=Logger.getLogger("ebanking");
		//PropertyConfigurator.configure("Log4j.properties");
		
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	

}
