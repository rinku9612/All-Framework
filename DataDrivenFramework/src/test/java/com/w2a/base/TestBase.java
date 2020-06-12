package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;



public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;



	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {
		if (driver == null) {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			PropertyConfigurator.configure("Log4j.properties");
			log.debug("Config File Loaded !!!!!");
			config.getProperty("browser");
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR File Loaded !!!!!");
			OR.getProperty("bmlBtn");
		}

		if (config.getProperty("browser").equals("chrome")) {
			System.setProperty(config.getProperty("CHROME_KEY"),System.getProperty("user.dir")+config.getProperty("CHROME_VALUE"));
			driver = new ChromeDriver();
			log.debug("Chrome Launched !!!!!");
		} else if (config.getProperty("browser").equals("firefox")) {
			System.setProperty(config.getProperty("FIREFOX_KEY"), System.getProperty("user.dir")+config.getProperty("FIREFOX_VALUE"));
			driver=new FirefoxDriver();
			log.debug("FireFox Launched !!!!!");

		} else if (config.getProperty("browser").equals("edge")) {
			System.setProperty(config.getProperty("EDGE_KEY"), System.getProperty("user.dir")+config.getProperty("EDGE_VALUE"));
			driver=new EdgeDriver();
			log.debug("Edge Launched !!!!!");

		} else
			log.debug("WARNING:No Browser Selected,Please Select a Valid Browser  !!!!");
			

		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to Application Url:"+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("IWT")), TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 5);

	}
	

	@AfterSuite
	public void tearDown() {
		if (driver != null)
			driver.quit();
		log.debug("Test Execution Completed!!!!!");


	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
			}
		catch(NoSuchElementException e) {
			return false;
			}
	}
}
