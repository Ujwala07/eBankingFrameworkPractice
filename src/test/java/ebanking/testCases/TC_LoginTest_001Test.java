package ebanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ebanking.pageObjects.LoginPage;

public class TC_LoginTest_001Test extends BaseClass {
	
	@Test
	public void verifyLogin()
	{
		LoginPage lp=goToApplication();
		logger.info("application is accessed");
		lp.loginToApp(userName, password);
		logger.info("logged in");
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		logger.info("page is redirected to bank page");
	}

}
