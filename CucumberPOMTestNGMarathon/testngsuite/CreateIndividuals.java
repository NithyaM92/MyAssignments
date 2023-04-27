package testngsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIndividuals extends BaseclassSalesforce {
	
	@BeforeTest
	public void setFilename()
	{
		fileName = "CreateIndivuduals";
	}
	
	@Test (priority = 1, dataProvider = "sendData")
	public void runCreateIndividuals(String individualName) {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
		/*boolean displayed = driver.findElement(By.xpath("//span[text()='Recently Viewed']")).isDisplayed();
		if(displayed) {
		driver.findElement(By.xpath("//lightning-icon[@icon-name='utility:close']")).click();
		}*/
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();

		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", clk);
		//String individualName = "SubiV";
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(individualName);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		if(text.equalsIgnoreCase(individualName))
		{
			System.out.println("Individual created successfully : " + text);
		}
		
		else
		{
			System.out.println("Problem with the new Individual creation");
		}

	}

}
