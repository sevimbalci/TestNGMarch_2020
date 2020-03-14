package com.hubspot.pages;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	//locators
	//nonpage factory
	By emailId=By.id("username");
	By password=By.id("password");
	By loginBtn=By.id("loginBtn");
	
	//By clickBtn=By.xpath("//a[@data-button-use='primary']");
	//constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//actions
	
	public String getLoginPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
		//return driver.getTitle();
	}
	public HomePage dologin(String username, String pwd){
		
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);

//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		 return new HomePage(driver);
	}
	
}
