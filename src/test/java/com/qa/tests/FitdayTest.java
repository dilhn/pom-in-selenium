package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.util.Constants;



public class FitdayTest extends BaseTest {

	@Test
	public void headTailsTitleValidation() {
		String actualTitle = hp.homePageTitle();
		//System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, Constants.HEAD_TAILS_TITLE);  
	}
	
	
}