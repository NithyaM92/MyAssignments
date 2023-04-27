package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesPOM.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends 	BaseClass{
	
	public LoginPage()
	{
		
	} 

	public LoginPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	@And ("Enter Username as {string}")
	public  LoginPage enterUsername(String uName)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
		return this;
	}
	
	@And ("Enter Password as {string}")
	public LoginPage enterPassword(String pWord)
	{
		driver.findElement(By.id("password")).sendKeys(pWord);
		return this;
	}
	
	@When ("Click on Login buuton")
	public LoginPage clickLogin()
	{
		driver.findElement(By.id("Login")).click();
		return this;
	}
	
	@Then("Homepage is displayed")
	public HomePage verifyHomepage()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return new HomePage(driver);
	}
	
	
}
