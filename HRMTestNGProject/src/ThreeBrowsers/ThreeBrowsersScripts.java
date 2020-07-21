package ThreeBrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThreeBrowsersScripts {
	public static WebDriver driver;
	

	@Parameters("browser")
	@BeforeTest

	
	public void BrowserLaunch(String browserName) {
         		
		if(browserName.equalsIgnoreCase("Chrome")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\Driver83\\chromedriver.exe";
			System.out.println(driverPath);
			
			System.setProperty("webdriver.chrome.driver",driverPath);
			
		    driver  = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\Driver83\\geckodriver.exe";
			System.out.println(driverPath);
			
			System.setProperty("webdriver.gecko.driver",driverPath);
			
		    driver  = new FirefoxDriver();
			
		}
	}
	
 
}
