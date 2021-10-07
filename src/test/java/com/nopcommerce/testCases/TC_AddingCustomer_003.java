package com.nopcommerce.testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.*;


public class TC_AddingCustomer_003 extends BaseClass {

	@Test
	public void addCustomer() throws Exception
	{
		driver.get(baseURL);
		logger.info("URL opened....");
		LoginPage lp=new LoginPage(driver);
		lp.setUserNmae(username);
		logger.info("User Name provided....");

		lp.setPassword(password);
		logger.info("Password Provided....");

		lp.clkLogin();
		logger.info("Logged in....");
		AddCustomer ac=new AddCustomer(driver);
		ac.clkMainCustomer();
		ac.clkSubCustomer();
		ac.clkAddNew();
		logger.info("Providing Customer Details....");
		String email=randomstring() + "@gmail.com";
		ac.setUserName(email);
		ac.setPassword("daniel");
		ac.setFirstName("Daniel");
		ac.setLastName("Pravin");
		ac.setGender("Male");
		ac.setDob("6/23/2014");
		ac.setComapany("Dani");
		ac.setTax();
		Thread.sleep(5000);
		ac.setNews("Test store 2");
		//ac.setRoles("Registered");
		//ac.setRoles("Vendors");
		ac.setVendors("Vendor 1");
		ac.setComment("Hello");
		ac.clkSave();
		Thread.sleep(5000);
		
		
		String msg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		System.out.println(msg);
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("Customer created....");
			
		}
		else
		{
			captureScreen(driver, "addCustomer");
			Assert.assertTrue(false);
		}
	}
//	div[@id='ajaxBusy']
}
