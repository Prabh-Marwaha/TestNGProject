package ThreeBrowsers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondClassForLogout extends ThreeBrowsersScripts {
	
	
	@Test(priority=3)
	public void LoginCheckSoftAssert() {
		 SoftAssert sa = new SoftAssert();
		 System.out.println("start execution");
			
		   String expText = "Welcome Admin";
		   String actualText = "Welcome Admin";
		   
		   sa.assertEquals(actualText, expText);
		  
		   System.out.println("end execution");
		   sa.assertAll();
		   
	   }
	
	@Test(priority=4)
	public void LogOut() {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}
