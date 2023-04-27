package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	public ChromeDriver driver;
	public String excelFileName;
	
	@Parameters({"url","username","password"})
	@BeforeMethod(alwaysRun = true)
	public void preCondition(String url, String uName, String pWord) {
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();

	}
	@AfterMethod(alwaysRun = true)
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider()//(indices = {0})- For one row
	public String[][] sendData() throws IOException
	{
		return ReadExcel.readExcel(excelFileName);
	}

}
