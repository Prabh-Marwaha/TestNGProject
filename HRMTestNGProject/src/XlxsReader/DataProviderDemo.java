package XlxsReader;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	@Test
	public void doLaunch(){
		String driverPath=System.getProperty("user.dir")+"\\src\\Driver83\\chromedriver.exe";
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@DataProvider
	public String[][] readData() throws IOException{
		//1.get the path of excel sheet
		String sheetPath=System.getProperty("user.dir")+"\\src\\TestData\\testData.xlsx";
		ExcelDataReader xlr=new ExcelDataReader(sheetPath);
		
		//2.to count rows
		int rCount=xlr.getRowCount("Login");
		System.out.println(rCount);
		
		//3.to count columns
		int cCount=xlr.getColumnCount();
		System.out.println(cCount);
		
		//create 2D Array
		String[][] dataArr=new String[rCount-1][cCount];	
		for(int row=1;row<rCount;row++) {
			for(int col=0;col<cCount;col++) {
				dataArr[row-1][col]=xlr.getCellData(row,col);
			}
		}
		return dataArr;
	}
	
	@Test(dataProvider="readData",priority=1)
	public void doLogin(String username,String password) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
//		System.out.println(username+"-----------"+password);
	}

}
