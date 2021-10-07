package com.nopcommerce.testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LocateProduct;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchProduct;

public class TC_LocateProducct_007 extends BaseClass {
	
	@Test
	public void locateProduct() throws Exception {
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
		
		LocateProduct locpro=new LocateProduct(driver);
		SearchProduct sp=new SearchProduct(driver);
		sp.clkCatalog();
		sp.clkProducts();
		Thread.sleep(5000);
		locpro.locateItem("EG_GEM_NL");
		Thread.sleep(2000);
		//String msg=driver.findElement(By.xpath("//h1[contains(text(),'Elegant Gemstone Necklace')]")).getText();
		//System.out.println(msg);
		/*if(msg.contains("Elegant Gemstone Necklace"))
		{
			Assert.assertTrue(true);
			logger.info("Product found successfully....");
			
		}
		else
		{
			captureScreen(driver, "locateProduct");
			Assert.assertTrue(false);
		}*/
		
	}
}
