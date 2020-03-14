package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class HomePage extends  BasePage{

WebDriver driver;
	ElementUtil elementUtil;
	////h1[@class='Sales Dashboard'] ---header
	////span[@class='account-name ']...accocunt
	

////h5[@class='Heading-sc-9dtc71-0 H5-sc-1o270om-0 jaYosH H5GroupHeader-sc-1w566qv-0 jTRoPf']
//h5[@class='TRoPf']
	//By header=By.xpath("//h1[@class='Sales Dashboard']");
	By header = By.xpath("//h1[@class='private-page__title']");
	
	//By accountName=By.xpath("//span[@class='account-name ']");
	By accountName=By.xpath("//a[@id='account-menu']//img[contains(@class,'nav-avatar')]");
	
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contatcChildTab = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil =new ElementUtil(driver);
		
	}
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
		
		
		
	}
	public String getHomePageHeader(){
		return elementUtil.doGetText(header);
		//return driver.findElement(header).getText();
	}
	
	public String verifyLoggedInAccountName(){
		return elementUtil.doGetText(accountName);
		//return driver.findElement(accountName).getText();
		
	}
	
	//helper method
			private void clickOnContacts(){
				elementUtil.doClick(contactMainTab);
				elementUtil.doClick(contatcChildTab);
			}
			public ContactsPage gotoContactsPage(){
				clickOnContacts();
				return new ContactsPage(driver);
			}		
			

	
	
	
}
