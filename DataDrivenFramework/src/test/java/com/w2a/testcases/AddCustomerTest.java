package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProvider ="getData")
	public void addCustomer(String fname,String lname,String pincode,String alerttext) throws InterruptedException {
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("f_Name"))).sendKeys("rohitsingh");
		driver.findElement(By.cssSelector(OR.getProperty("l_Name"))).sendKeys("kumar");
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys("840792");
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	
		Assert.assertTrue(alert.getText().contains(alerttext));
		Reporter.log("HI ROHIT"+alert.getText());
		Thread.sleep(3000);
		alert.accept();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		String sheetName="addCustomer";
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		Object [][] data=new Object[rows-1][cols]; 
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for (int colNum=0;colNum<cols;colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
		
		
		
	}

}
