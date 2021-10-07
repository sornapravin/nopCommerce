package com.nopcommerce.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilitizes.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider = "LoginData")
	public void loginTest(String user,String pwd) throws Exception 
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL opened....");
		LoginPage lp=new LoginPage(driver);
		lp.setUserNmae(user);
		logger.info("User Name provided....");
		

		lp.setPassword(pwd);
		logger.info("Password Provided....");

		lp.clkLogin();
		
		Thread.sleep(3000);
		//Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clkLogout();
			logger.info("Page Logged in successfully....");
		}
		else {
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
