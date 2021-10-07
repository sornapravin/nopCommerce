package com.nopcommerce.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer {
	public WebDriver lDriver;
	public AddCustomer(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	//By lnkCustomer_Main = By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]");
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]")
	 
	WebElement lnkCustomer_Main;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	@CacheLookup
	WebElement lnkCustomer_Sub;
	
	@FindBy(xpath="//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]")
	@CacheLookup
	WebElement btnAddNew;
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id = "FirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(id = "LastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(id= "Gender_Male")
	@CacheLookup
	WebElement rbGenMale;
	
	@FindBy(id= "Gender_Female")
	@CacheLookup
	WebElement rbGenFemale;
	
	@FindBy(id= "DateOfBirth")
	@CacheLookup
	WebElement dob;
	
	@FindBy(id= "Company")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(id="IsTaxExempt")
	@CacheLookup
	WebElement cbTax;
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")
	@CacheLookup
	WebElement sltNews;
	
	
	
	@FindBy(xpath="//select[@id='SelectedNewsletterSubscriptionStoreIds']/option[1]")
	@CacheLookup
	WebElement lstNewsOp1;
	
	@FindBy(xpath="//select[@id='SelectedNewsletterSubscriptionStoreIds']")
	@CacheLookup
	WebElement lstNewsOp1a;
	/*
	 * @FindBy(xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/select[1]/option[1]")
	@CacheLookup
	WebElement lstNewsOp1;
	@FindBy(xpath="//option[contains(text(),'Test store 2')]")
	@CacheLookup
	WebElement lstNewsOp2;
	
	*/
	
	@FindBy(xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/select[1]/option[2]")
	@CacheLookup
	WebElement lstNewsOp2;
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
	@CacheLookup
	WebElement sltRoles;
	
	@FindBy(xpath="//option[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstRolesOp1;
	
	@FindBy(xpath="//option[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement lstRolesOp2;
	
	@FindBy(xpath="//option[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstRolesOp3;
	
	@FindBy(xpath="//option[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstRolesOp4;
	
	@FindBy(xpath="//option[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstRolesOp5;
	/*
	@FindBy(xpath="//option[contains(text(),'Not a vendor')]")
	@CacheLookup
	WebElement sltVendorOp1;*/

	@FindBy(id="VendorId")
	@CacheLookup
	WebElement sltVendor;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	@CacheLookup
	WebElement txtAreaComment;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
	@CacheLookup
	WebElement btnSave;
	
	public void clkMainCustomer()
	{
		lnkCustomer_Main.click();
	}
	public void clkSubCustomer()
	{
		lnkCustomer_Sub.click();
	}
	public void clkAddNew()
	{
		btnAddNew.click();
	}
	public void setUserName(String uname)
	{
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			rbGenMale.click();
		}
		else if(gender.equals("Female"))
		{
			rbGenFemale.click();
		}
	}
	public void setDob(String birthdate)
	{
		dob.sendKeys(birthdate);
	}
	public void setComapany(String company)
	{
		txtCompany.sendKeys(company);
	}
	public void setTax()
	{
		cbTax.click();
	}
	public void setNews(String news)
	{
		sltNews.click();
		WebDriverWait wait = new WebDriverWait(lDriver,20);
		
		WebElement abc = lDriver.findElement(By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']/option[text()='Your store name']"));
//		wait.until(ExpectedConditions.elementToBeClickable(abc));
//		abc.click();
//		lDriver.findElement(By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']/option[text()='Your store name']")).click();
		Select newsLetter = new Select(lstNewsOp1a);
//		newsLetter.selectByValue(news);
//		newsLetter.selectByIndex(1);
		List<WebElement> option = newsLetter.getOptions();
		System.out.println(option.toString());
		

		//WebElement listNews;
		try {
			switch(news)
			{
			case "Your store name":
				JavascriptExecutor js= (JavascriptExecutor)lDriver;
				js.executeScript("arguments[0].click();", abc);
				//listNews=lstNewsOp1;
				break;
			case "Test store 2":
				JavascriptExecutor js1= (JavascriptExecutor)lDriver;
				js1.executeScript("arguments[0].click();", abc);
				//listNews=lstNewsOp2;
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JavascriptExecutor js= (JavascriptExecutor)lDriver;
		//js.executeScript("arguments[0].click();", listNews);
	}
	public void setRoles(String roles)
	{
		lDriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")).click();
		sltRoles.click();
		WebElement listItems = null;
		switch(roles)
		{
		case "Administrators":
			listItems=lstRolesOp1;
			break;
		case "Forum Moderators":
			listItems=lstRolesOp2;
			break;
		case "Guests":
			listItems=lstRolesOp3;
			break;
		case "Registered":
			listItems=lstRolesOp4;
			break;
		case "Vendors":
			listItems=lstRolesOp5;
			break;
		}
		JavascriptExecutor js= (JavascriptExecutor)lDriver;
		js.executeScript("arguments[0].click();", listItems);
	}
	public void setVendors(String Vendors)
	{
		Select drp=new Select(sltVendor);
		drp.selectByVisibleText(Vendors);
	}
	public void setComment(String comment)
	{
		txtAreaComment.sendKeys(comment);
	}
	public void clkSave()
	{
		btnSave.click();
	}
}
