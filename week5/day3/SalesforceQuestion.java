package week5.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceQuestion extends BaseclassSalesforce {
	
	@BeforeTest
	public void setFilename()
	{
		fileName = "Questions";
	}
	
	@Test(dataProvider = "sendData")
	public void askQuestion(String question, String details) throws InterruptedException
	{
		WebElement appLauncher = driver.findElement(By.className("slds-icon-waffle"));
		driver.executeScript("arguments[0].click()", appLauncher);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		driver.findElement(By.xpath("//div[contains(@class,'slds-app-launcher__tile-body')]")).click();
		WebElement chatterElement = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click()", chatterElement);
		
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		String title = driver.getTitle();
		System.out.println("title of the page is :"+title);
		if(title.contains("Chatter"))
		{
			System.out.println("Page validated");
		}
		else
		{
			System.out.println("Page not validated");
		}
		driver.findElement(By.xpath("//textarea[contains(@class,'questionTitleField')]")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@class,'text-area__content')]/p")).sendKeys(details);
		driver.findElement(By.xpath("//button[contains(text(),'Ask')]")).click();
	}	
}
