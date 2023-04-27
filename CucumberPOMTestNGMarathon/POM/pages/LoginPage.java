package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends 	BaseClass{

	public LoginPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public  LoginPage enterUsername(String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String pWord)
	{
		driver.findElement(By.id("password")).sendKeys(pWord);
		return this;
	}
	
	public HomePage clickLogin()
	{
		driver.findElement(By.id("Login")).click();
		String title = driver.getTitle();
		System.out.println(title);
		return new HomePage(driver);
	}
	
	
}
