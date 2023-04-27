package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesPOM.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{
	
	public HomePage()
	{
		
	}
	
	public HomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	@When ("Click on App launcher icon")
	public HomePage clickAppLauncherIcon()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	
	@And ("Click on View All link")
	public HomePage clickViewAllLink()
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	
	@And ("Click on Individuals link")
	public Individualspage clickViewIndividualsLink()
	{
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		
		return new Individualspage(driver);
	}
	
	
	
	

}
