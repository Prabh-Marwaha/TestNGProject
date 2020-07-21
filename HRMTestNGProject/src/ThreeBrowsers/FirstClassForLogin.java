package ThreeBrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstClassForLogin extends ThreeBrowsersScripts {
	
	   @Test(priority=1)
	  public void MaximizeAndLink() {
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
			
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  
	     }
	
	   @Test(priority=2)
	   public void LoginPage() {
		   
		    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		   
	   }
	   

}
