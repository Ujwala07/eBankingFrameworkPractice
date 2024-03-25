package ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="[value='LOGIN']")
	WebElement loginBtn;
	
	@FindBy(css="[value='RESET']")
	WebElement resetBtn;
	
	@FindBy(css="a[href*='Logout']")
	WebElement logoutBtn;
	
	
	public void loginToApp(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();		
	}
	
	public void logoutFromApp()
	{
		logoutBtn.click();
	}

}
