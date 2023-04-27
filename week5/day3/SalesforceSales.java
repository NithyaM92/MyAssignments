package week5.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceSales extends EdgeBaseclassSalesforce {
	
	@BeforeTest
	public void setFilename()
	{
	    fileName = "Sales";
	}
	
	
	@Test (dataProvider = "sendData")
	public void salesForceSales(String opportunityName, String amount ) throws InterruptedException
	{

		WebElement appLauncher = driver.findElement(By.className("slds-icon-waffle"));
		driver.executeScript("arguments[0].click()", appLauncher);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("sales");
		driver.findElement(By.xpath("//a[contains(@class,'text-heading_small')]/following::p[contains(text(),'Manage your sales')]")).click();
		Thread.sleep(500);
		
		WebElement filterIcon = driver.findElement(By.xpath("//div[contains(@class,'uiPopupTrigger forceMenuTriggerIcon')]//a"));
		Actions act = new Actions(driver);
		act.scrollToElement(filterIcon);
		driver.executeScript("arguments[0].click()", filterIcon);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement allOpportunity = driver.findElement(By.xpath("//a[@title='All Opportunities']"));
		wait.until(ExpectedConditions.visibilityOf(allOpportunity));
		allOpportunity.click();
		Thread.sleep(1000);
		WebElement allKey = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		wait.until(ExpectedConditions.visibilityOf(allKey));
		driver.executeScript("arguments[0].click()", allKey);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityName);
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Type, --None--')]")).click();
		WebElement typeElement = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='New Customer']"));
		act.scrollToElement(typeElement);
		typeElement.click();
		
		WebElement leadBox = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Source, --None--')]"));
		driver.executeScript("arguments[0].click()", leadBox);
		WebElement leadElement = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Partner Referral']"));
		act.scrollToElement(leadElement);
		leadElement.click();
		
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("21/04/2023");
		
		driver.findElement(By.xpath("//button[@aria-label='Stage, --None--']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
		
		WebElement primaryCampaign = driver.findElement(By.xpath("//input[contains(@placeholder,'Search Campaigns')]"));
		driver.executeScript("arguments[0].click()", primaryCampaign);
		driver.findElement(By.xpath("(//ul[@aria-label='Recent Campaigns']/li)[2]")).click();
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String opportunityText = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println(opportunityText);
		boolean equals = opportunityText.equals(opportunityName);
		if(equals)
		{
			System.out.println("Opportunity created successfully : "+ opportunityText );
		}
		else
		{
			System.out.println("Problem creation error");
		}
		
	}

}
