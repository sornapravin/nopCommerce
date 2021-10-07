package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilitizes.ReadConfig;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	public static Logger logger;
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserEmail();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(String br)
	{
		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
			driver=new ChromeDriver();
		}
		else if(br.equals("msedge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgeDriver());
			driver = new EdgeDriver();
		}
		
	}
	@AfterClass(alwaysRun = true)
	public void TearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screetshots/" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomstring() {
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
