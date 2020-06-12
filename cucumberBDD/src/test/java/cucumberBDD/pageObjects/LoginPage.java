package cucumberBDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
	
	@FindBy(id = "identifierId")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;
	@FindBy(xpath = "//span[@class='CwaK9']")
	WebElement next;
	public void setUserName(String uname) {
		userName.sendKeys(uname);
	}
	public void setPass(String pwd) {
		pass.sendKeys(pwd);
	}
	public void clickNext() {
		next.click();
	}
	
	
}
