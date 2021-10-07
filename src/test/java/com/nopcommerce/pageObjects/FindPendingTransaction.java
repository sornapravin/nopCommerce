package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPendingTransaction {
	public WebDriver lDriver;
	public FindPendingTransaction(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-cart']")
	@CacheLookup
	WebElement lnkSales;
	
	@FindBy(xpath="//p[contains(text(),'Orders')]")
	@CacheLookup
	WebElement lnkOrders;
	
	By webTable= By.xpath("//table/tbody/tr");
	
	public void clkSales()
	{
		lnkSales.click();
	}
	public void clkOrders()
	{
		lnkOrders.click();
	}
	public void setPendingStatus(String orderStatus)
	{
		List<WebElement> rows=lDriver.findElements(webTable);
		String beforeXpath="//table/tbody/tr[";
		String afterXpath="]/td[3]/span";
		int rowSize=rows.size();
		for (int i=1;i<=rowSize;i++)
		{
			String status=lDriver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			System.out.println(status);
			if(status.equals(orderStatus))
			{
				lDriver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]/input")).click();
				lDriver.findElement(By.xpath("//tbody/tr["+i+"]/td[10]/a")).click();
				break;
			}
		}
	}
}
