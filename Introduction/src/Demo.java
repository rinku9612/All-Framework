import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo {
	public static void main(String[] args) {
		String path = "D:\\Jar\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--headless");
		
		WebDriver driver=new ChromeDriver(cp);
	
		Method [] name=driver.getClass().getMethods();
		for(int i=0;i<name.length;i++) {
		System.out.println(name[i]);
		}
//		driver.get("https:\\www.google.com");
//		System.out.println(driver.getTitle());
	}
}
