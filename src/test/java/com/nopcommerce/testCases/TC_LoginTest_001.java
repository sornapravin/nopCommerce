package com.nopcommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws Exception 
	{
		driver.get(baseURL);
		logger.info("URL opened....");
		LoginPage lp=new LoginPage(driver);
		lp.setUserNmae(username);
		logger.info("User Name provided....");

		lp.setPassword(password);
		logger.info("Password Provided....");

		lp.clkLogin();
		
		Thread.sleep(5000);
		//Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clkLogout();
			logger.info("Page Logged in successfully....");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
	}
	
}
}
