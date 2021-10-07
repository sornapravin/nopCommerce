package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchProduct {
	public WebDriver lDriver;
	public SearchProduct(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy (xpath="//i[@class='nav-icon fas fa-book']")
	@CacheLookup
	WebElement lnkCatalog;
	
	@FindBy (xpath="//a[@href='/Admin/Product/List']//p[contains(text(),'Products')]")
	@CacheLookup
	WebElement lnkProducts;
	
	@FindBy (xpath="//input[@id='SearchProductName']")
	@CacheLookup
	WebElement txtProductName;
	
	@FindBy (xpath="//select[@id='SearchCategoryId']")
	@CacheLookup
	WebElement drpCatogory;
	
	@FindBy (xpath="//select[@id='SearchProductTypeId']")
	@CacheLookup
	WebElement drpProType;
	
	@FindBy (id="search-products")
	@CacheLookup
	WebElement btnSearch;
	
	public void clkCatalog()
	{
		lnkCatalog.click();
	}
	public void clkProducts()
	{
		lnkProducts.click();
	}
	public void setProductName(String productname)
	{
		txtProductName.sendKeys(productname);
	}
	public void setCatagory(String catoption)
	{
		Select catagoryOption = new Select(drpCatogory);
		catagoryOption.selectByVisibleText(catoption);
	}
	public void setProductType(String productoption)
	{
		Select productOption = new Select(drpProType);
		productOption.selectByVisibleText(productoption);
	}
	public void clkSearch()
	{
		btnSearch.click();
	}
	
}
