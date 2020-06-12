package com.inetBanking.testcase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPage;
import com.inetBanking.utils.XLUtils;

public class TC_002_LoginTestXLDP extends BaseTest {
	LoginPage lp;

	//@Test(dataProvider="LoginData")
	public void loginDD(String user, String pwd) throws InterruptedException {

		lp = new LoginPage(driver);
		// lp.closeBtn(); logger.info("video closed");
		lp.setUser(user);
		logger.info("username provided");
		lp.setPass(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("login clicked");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);


		if(isAlertPresent()==true) 
		{ 
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); 
			Assert.assertTrue(false);
			logger.warn("Login failed"); } 
		else {
			Assert.assertTrue(true);
			lp.logoutBtn();
			logger.info("logout passed");
			Thread.sleep(3000);

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

//	@DataProvider(name = "LoginData")
	String[][] getdata() throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/java/com/inetBanking/testData/testData.xlsx";
		int rows = XLUtils.getRowCount(path, "Sheet1");
		int columns = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] logindata = new String[rows][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;

	}

}
