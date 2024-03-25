package ebanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ebanking.pageObjects.LoginPage;
import ebanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class BaseClass {

	public WebDriver driver;
	
	ReadConfig rc=new ReadConfig();
	public String baseURL=rc.getApplicationURL();
	public String userName=rc.getUserName();
	public String password=rc.getPassword();
	public Logger logger;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void launchAndInitializeBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		//logger = LogManager.getLogger(BaseClass.class.getName());
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");   
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public LoginPage goToApplication()
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"\\Screenshot\\"+testCaseName+".png";
		File dest=new File(destPath);
		FileUtils.copyFile(src, dest);
		return destPath;
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public String randomString()
	{
		String randomStr=RandomStringUtils.randomAlphabetic(6);
		return randomStr;
	}
	
	public String randomNumber()
	{
		String randomNo=RandomStringUtils.randomAlphanumeric(10);
		return randomNo;
	}
}
