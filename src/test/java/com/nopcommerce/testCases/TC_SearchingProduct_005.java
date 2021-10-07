package com.nopcommerce.testCases;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchProduct;

public class TC_SearchingProduct_005 extends BaseClass {

	@Test
	public void searchProduct() throws Exception
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
		SearchProduct sp=new SearchProduct(driver);
		sp.clkCatalog();
		sp.clkProducts();
		sp.setProductName("Asus N551JK-XO076H Laptop");
		sp.setCatagory("Computers >> Notebooks");
		sp.setProductType("Simple");
		logger.info("Product details entered....");
		sp.clkSearch();
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr[1]/td[3]")).getText();
		
		System.out.println(msg);
		if(msg.contains("Asus N551JK-XO076H Laptop"))
		{
			Assert.assertTrue(true);
			logger.info("Product found successfully....");
			
		}
		else
		{
			captureScreen(driver, "searchProduct");
			Assert.assertTrue(false);
		}
	}
}
