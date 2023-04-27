package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesPOM.BaseClass;
import io.cucumber.java.en.Then;

public class ViewIndividualPage extends BaseClass {
	
	public ViewIndividualPage()
	{
		
	}
	
	public ViewIndividualPage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	@Then("Individual created successfully (.*)$")
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
