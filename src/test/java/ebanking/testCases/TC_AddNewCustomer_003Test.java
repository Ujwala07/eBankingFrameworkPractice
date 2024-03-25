package ebanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ebanking.pageObjects.AddCustomerPage;
import ebanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003Test extends BaseClass {
	
	@Test
	public void addNewCustomer()
	{
		LoginPage lp=goToApplication();
		logger.info("application is accessed");
		lp.loginToApp(userName, password);
		
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.goToAddCustomer();
		acp.setCustName("saavi");
		acp.setGender("female");
		acp.setDOB("23-03-2024");
		acp.setAddress("gadsncjkdscjkdsc");
		acp.setCity("mumbai");
		acp.setState("MH");
		acp.setPinNo("123644");
		
		String no=randomNumber();
		acp.setPhoneNumber("1234567890");
		
		String email=randomString()+"@gmail.com";
		acp.setEmailId(email);
		
		acp.setPassword("saavi123");
		
		acp.addNewCustomer();
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		Assert.assertTrue(res);
	}

}
