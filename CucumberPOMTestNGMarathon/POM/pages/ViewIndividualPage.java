package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class ViewIndividualPage extends BaseClass {
	
	public ViewIndividualPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	
	public void verifyNewIndividual(String individualName)
	{
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
