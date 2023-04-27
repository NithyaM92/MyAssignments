package testngsuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseclassSalesforce {
	
	public ChromeDriver driver;
	public String fileName;
	
	@BeforeMethod
	public void preCondition()
	{
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("nithyam@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider
	public String[][] sendData() throws IOException
	{
		return ReadExcelValues.readExecelValues(fileName);
	}

}
