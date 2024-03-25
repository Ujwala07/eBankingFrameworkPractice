package ebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ebanking.pageObjects.LoginPage;
import ebanking.utilities.ReadExcelDataUtility;

public class TC_LoginTestWithMultipleData_002 extends BaseClass{
	
	@Test(dataProvider="getData")
	public void verifyLoginForMultipleUsers(String un,String pw)
	{
		LoginPage lp=goToApplication();
		logger.info("application is accessed");
		lp.loginToApp(un, pw);
		logger.info("logged in");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("test case is failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.logoutFromApp();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\ebanking\\testData\\UserDataDrivenTesting.xlsx";
		String sheetName="Credentials";
		ReadExcelDataUtility xl=new ReadExcelDataUtility();
		
		int rowCount=xl.getRowCount(filePath, sheetName);
		int columnCount=xl.getColumnCount(filePath, sheetName);
		//System.out.println(rowCount+ " "+columnCount);
		
		String[][] data=new String[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				data[i-1][j]=xl.getCellData(filePath, sheetName, i, j);
			}
		}
		
		return data;
	}

}
