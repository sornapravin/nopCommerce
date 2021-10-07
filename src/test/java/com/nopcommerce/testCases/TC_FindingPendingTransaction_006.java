package com.nopcommerce.testCases;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.FindPendingTransaction;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_FindingPendingTransaction_006 extends BaseClass {
	@Test
	public void findStatus() throws Exception
	{
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
		FindPendingTransaction fpt=new FindPendingTransaction(driver);
		fpt.clkSales();
		fpt.clkOrders();
		Thread.sleep(5000);
		fpt.setPendingStatus("Pending");
		String msg=driver.findElement(By.xpath("//div[@class='font-weight-bold']")).getText();
		System.out.println(msg);
		if(msg.contains("Pending"))
		{
			Assert.assertTrue(true);
			logger.info("Pending Transaction found successfully....");
			
		}
		else
		{
			captureScreen(driver, "findStatus");
			Assert.assertTrue(false);
		}
	}

}
