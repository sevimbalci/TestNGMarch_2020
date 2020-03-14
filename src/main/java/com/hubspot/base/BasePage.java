package com.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public static String flash;
	
	public WebDriver initialize_driver(Properties prop){
	   //	String browser= "chrome";
        String browser=prop.getProperty("browser");  
        String headless=prop.getProperty("headless");
        flash=prop.getProperty("elementflash");
	   	if (browser.equalsIgnoreCase("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "/Users/sevimbalci/Documents/Drivers/chromedriver");
			//WebDriver driver=new ChromeDriver();
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public Properties initialize_properties(){
		prop=new Properties();
		
		try {
			FileInputStream ip= new FileInputStream("/Users/sevimbalci/"
					+ "Documents/workspace/JanuaryTestNG2020/src/main/java/config/hubspot/config/config.properties");
			prop.load(ip);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}

	public void quitBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	
	
	
}
