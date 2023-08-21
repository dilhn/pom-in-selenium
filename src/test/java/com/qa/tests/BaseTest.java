package com.qa.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.base.BaseClass;
import com.qa.pages.HomePage;


public class BaseTest {
	WebDriver driver;
	Properties prop;
	BaseClass bc;
	HomePage hp;

	
	@BeforeTest
	public void setUp() {

		bc = new BaseClass();
		prop = bc.init_properties();
		driver = bc.init_driver(prop);
		hp = new HomePage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
