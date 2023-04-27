package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage clickAppLauncherIcon()
	{
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	
	public HomePage clickViewAllLink()
	{
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
	}
	
	public Individualspage clickViewIndividualsLink()
	{
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		
		return new Individualspage(driver);
	}
	
	
	
	

}
