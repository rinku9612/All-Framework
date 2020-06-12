import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class TravelUi {

	public static void main(String[] args) {
		String path = "D:\\Jar\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		System.out.println("clicked round trip");
		WebElement src=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']"));
        Select sel1=new Select(src);
        sel1.selectByValue("GOI");System.out.println("selected source is:"+src.getText());
        
        driver.findElement(By.xpath("//div[@class='right1']/select/option[5]")).click();
        
      
		WebElement travelDate=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[5]/td[4]"));
		WebElement returnDate=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[5]/td[5]"));
	
		WebElement passengers=driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']/div[2]/div[2]/p/select"));
		WebElement currency=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		WebElement search=driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));


		/*
		 * src.click(); System.out.println("Source clicked is"+src.getText());
		 * dest.click(); System.out.println("Destination clicked is"+dest.getText());
		 */
		travelDate.click();
		System.out.println("Date clicked is"+travelDate.getText());
		returnDate.click();
		System.out.println("Date clicked is"+returnDate.getText());
		
		Select sel6=new Select(passengers);
		sel6.selectByValue("6");
		System.out.println("Passengers is"+passengers.getText());
		
		Select sel7=new Select(currency);
		sel7.selectByValue("INR");
		System.out.println("currency is"+currency.getText());
		
		search.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println("Test Passed");
		;
	}

}
