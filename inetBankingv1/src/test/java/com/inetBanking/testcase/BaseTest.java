package com.inetBanking.testcase;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utils.ReadConfig;





public class BaseTest {
	ReadConfig readConfig=new ReadConfig();

	public  String baseUrl=readConfig.getUrl();
	public  String username=readConfig.getUsername();
	public  String password=readConfig.getPass();
	public static WebDriver driver;
	public static Logger logger;
//
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty(readConfig.getChroKey(), readConfig.getChroPath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty(readConfig.getFireKey(), readConfig.getFirePath());
			driver=new FirefoxDriver();
			}
		else if(br.equals("edge")) {
			System.setProperty(readConfig.getEdgeKey(), readConfig.getEdgePath());
			driver=new EdgeDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
