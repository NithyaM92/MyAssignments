package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class BaseClass {
	
    public static ChromeDriver driver;
    public String fileName;
    
	@BeforeMethod
	public void preconditions()
	{
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@DataProvider
	public String[][] sendData() throws IOException
	{
	   return ReadExcel.readExcel(fileName);
	}
	
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}
}
