package week5.day3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseclassSalesforce {
	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url","username","password"})
	@BeforeMethod(alwaysRun = true)
	//public void preCondition(@Optional("https://login.salesforce.com/")String url, @Optional("nithyam@testleaf.com") String uName, @Optional("Welcome@123") String pWord)
	public void preCondition(String url, String uName, String pWord)
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		//driver.get("https://login.salesforce.com/");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.id("username")).sendKeys("nithyam@testleaf.com");
		//driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.id("Login")).click();
	}
	@DataProvider
	public String[][] sendData() throws IOException
	{
		return ReadExcelValues.readExecelValues(fileName);
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void postCondition()
	{
		driver.close();
	}
	
	

}
