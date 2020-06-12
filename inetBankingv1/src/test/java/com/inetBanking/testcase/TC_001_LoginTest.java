package com.inetBanking.testcase;





import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPage;

public class TC_001_LoginTest extends BaseTest{
@Test
public void login() {
	
	logger.info("url is opened");
	LoginPage lp=new LoginPage(driver);
	
	lp.setUser(username);logger.info("Entered user name");
	lp.setPass(password);logger.info("Entered password");
	lp.clickSubmit();logger.info("Clicked submit button");
	if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
	}
	else
		Assert.assertTrue(false);
}
}
