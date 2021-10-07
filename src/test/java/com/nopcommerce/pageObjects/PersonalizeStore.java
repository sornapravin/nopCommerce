package com.nopcommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalizeStore {
	public WebDriver lDriver;
	public PersonalizeStore(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy (xpath="//i[@class='nav-icon fas fa-cogs']")
	@CacheLookup
	WebElement lnkConfig;
	
	@FindBy (xpath="//p[contains(text(),'Settings')]")
	@CacheLookup
	WebElement lnkSettings;

	@FindBy (xpath="//p[contains(text(),' General settings')]")
	@CacheLookup
	WebElement lnkGeneralSettings;
		
	By cblink=By.xpath("*//div[@id='generalcommon-top-menu-items']//div[@class='card-body']//input[@type='checkbox']");
	
	@FindBy (xpath="*//button[@name='save']")
	@CacheLookup
	WebElement btnSave;
	
public void clkConfig()
{
	lnkConfig.click();
}
public void clkSettings()
{
	lnkSettings.click();
}
public void clkGeneralSettings()
{
	lnkGeneralSettings.click();
}
public void setCbList(String s)
{
	List<WebElement> cbOption=lDriver.findElements(cblink);
	for(WebElement el : cbOption){
		String op=el.getAttribute("data-val-required");
	    if(op.contains(s))
	    {
	        el.click();
	        break;
	    }
	}
}
public void clkSave()
{
	btnSave.click();
}

}