package ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='addcustomerpage']")
	WebElement addCustomerLink;
	
	@FindBy(name="name")
	WebElement custName;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement number;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submitBtn;
	
	@FindBy(name="res")
	WebElement resetBtn;
	
	public void setCustName(String name)
	{
		custName.sendKeys(name);
	}
	
	public void setGender(String gen)
	{
		gender.sendKeys(gen);
	}
	
	public void setDOB(String dobs)
	{
		dob.sendKeys(dobs);
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void setCity(String citi)
	{
		city.sendKeys(citi);
	}
	
	public void setState(String states)
	{
		state.sendKeys(states);
	}
	
	public void setPinNo(String pin)
	{
		pinno.sendKeys(pin);
	}
	
	public void setPhoneNumber(String no)
	{
		number.sendKeys(no);
	}
	
	public void setEmailId(String email)
	{
		emailid.sendKeys(email);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void addNewCustomer()
	{
		submitBtn.click();
	}
	
	public void resetData()
	{
		resetBtn.click();
	}
	
	public void goToAddCustomer()
	{
		addCustomerLink.click();
	}

}
