package com.qa.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass { 

	public WebDriver driver; // interface
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("chrome here--");  
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			System.out.println("chrome setup here--");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("incorrect browser name "+browserName);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url1"));
		
		return driver;
	}
	
	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
