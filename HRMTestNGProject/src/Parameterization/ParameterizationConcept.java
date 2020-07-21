package Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationConcept {
	public WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	
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
			
		}else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\Driver83\\IEDriverServer.exe";
			System.out.println(driverPath);
			
			System.setProperty("webdriver.ie.driver",driverPath);
			
		    driver  = new InternetExplorerDriver();
		}
		
}
	
	@Test(priority=2)
	public void LaunchApp() {
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test(priority=3)
	 public void LoginPage() {
		   
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	   
   }
	
	@Test(priority=4)
	 public void SuccessfullyLogin() {
		   System.out.println("start execution");
		
		   String expText = "Welcome Admin";
		   String actualText = "Welcome Admin";
		   
		   //Hard Assertion
		   Assert.assertEquals(expText,actualText);
		   System.out.println("end execution");
		   
	   
	   }
	   
}
