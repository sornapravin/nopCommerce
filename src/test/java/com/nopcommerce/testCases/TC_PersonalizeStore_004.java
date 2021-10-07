package com.nopcommerce.testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.PersonalizeStore;

public class TC_PersonalizeStore_004 extends BaseClass {

	@Test
	public void personalizeStore() throws Exception  {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL opened....");
		LoginPage lp=new LoginPage(driver);
		lp.setUserNmae(username);
		logger.info("User Name provided....");

		lp.setPassword(password);
		logger.info("Password Provided....");

		lp.clkLogin();
		logger.info("Logged in....");
		PersonalizeStore ps=new PersonalizeStore(driver);
		ps.clkConfig();
		ps.clkSettings();
		ps.clkGeneralSettings();
		String s="Home page";
		ps.setCbList(s);
		String p="New products";
		ps.setCbList(p);
		Thread.sleep(5000);
		ps.clkSave();
		
		String msg = driver.findElement(By.xpath("*//div[@class='alert alert-danger alert-dismissable']")).getText();
		
		System.out.println(msg);
		if(msg.contains("For security purposes, the feature you have requested is not available on the demo site."))
		{
			Assert.assertTrue(true);
			logger.info("Personalize store successfully updated ....");
			
		}
		else
		{
			captureScreen(driver, "personalizeStore");
			Assert.assertTrue(false);
		}
	}
}
