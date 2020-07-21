package TestNGAnnotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsScriptsHRM {

	static WebDriver driver;
	
	@BeforeSuite
	
	public void LaunchApp() {
         		
				String driverPath = System.getProperty("user.dir") + "\\src\\Driver83\\chromedriver.exe";
				System.out.println(driverPath);
				
				System.setProperty("webdriver.chrome.driver",driverPath);
				
			    driver  = new ChromeDriver();
					
	}
	
   @BeforeTest
  
  public void Maximize() {
	    driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  
     }
  
   @BeforeClass
  
  public void Sleep() {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
  }
  
   @BeforeMethod
  
  public void Clear() {
	  
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
	  
  }
  
   @Test(priority=1)
  public void LoginValid_Valid() throws InterruptedException {
	  
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }
  
  @Test(priority=2)
  public void LoginInvalid_Invalid() {
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("hello456");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
   }
  
  @Test(priority=3)
  public void LoginInvalid_Valid() {
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
  }
  
  @Test(priority=4)
  public void LoginValid_Invalid() {
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("hi222");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
  }
  
  @AfterClass
  public void TerminateApp() {
	  driver.quit();
	  
  }
  
}
	  
  
