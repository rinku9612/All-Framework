package com.inetBanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="uid")      WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement submit;
	@FindBy(xpath ="/html/body/div[3]/div/ul/li[10]/a")  WebElement logout;
	@FindBy(id="closeBtn")   WebElement closeBtn;
	
	public void closeBtn() {closeBtn.click();}
	public void setUser(String uname) {username.sendKeys(uname);}
	public void setPass(String pass) {password.sendKeys(pass);}
	public void clickSubmit() {submit.click();}
	public void logoutBtn() {logout.click();}
	
}
 