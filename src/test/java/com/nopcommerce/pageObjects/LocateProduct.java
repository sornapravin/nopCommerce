package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LocateProduct {
	public WebDriver lDriver;
	public LocateProduct(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	By noOfPages=By.xpath("//*[@id=\"products-grid_paginate\"]//li");
	
	By webTable= By.xpath("//table/tbody/tr");
	
	public void locateItem(String item) throws Exception
	{
		List<WebElement> pages=lDriver.findElements(noOfPages);
		int pageCount=pages.size();
		List<WebElement> rows=lDriver.findElements(webTable);
		String beforeXpath="//table/tbody/tr[";
		String afterXpath="]/td[4]";
		int rowSize=rows.size();
		for(int i=2;i<=pageCount-1;i++)
		{
			i=i+1;
			for (int j=1;j<=rowSize;j++)
			{
				String skuName=lDriver.findElement(By.xpath(beforeXpath+j+afterXpath)).getText();
				System.out.println(skuName);
				if(skuName.equals(item))
				{
					lDriver.findElement(By.xpath("//tbody/tr["+j+"]/td[1]/input")).click();
					//lDriver.findElement(By.xpath("//tbody/tr["+j+"]/td[8]/a")).click();
					break;
				}
			}
			lDriver.findElement(By.xpath("//*[@id=\"products-grid_paginate\"]//li["+i+"]")).click();
			i=i-1;
			Thread.sleep(3000);
		}
	}
}
