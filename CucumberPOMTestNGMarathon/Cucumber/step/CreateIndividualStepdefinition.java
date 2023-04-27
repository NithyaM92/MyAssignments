package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateIndividualStepdefinition extends BaseClass {

    
	@When("Click on App launcher icon")
	public void click_on_app_launcher_icon() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@And("Click on View All link")
	public void click_on_view_all_link() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@And("Click on Individuals link")
	public void click_on_individuals_link() {
		WebElement scroll = driver.findElement(By.xpath("//p[text()='Party Consent']"));
		driver.executeScript("arguments[0].scrollIntoView();", scroll);
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].click();", individual);
	}
	
	@And("click on Individual dropdown in the next page")
	public void click_on_individual_dropdown() {
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
	}

	@And("click on New Individual option")
	public void click_on_new_individual_option() {
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", clk);
	}

	@Then("New Individual screen form wil be displayed")
	public void new_individual_screen_form_wil_be_displayed() {
	   String title = driver.getTitle();
	   System.out.println(title);
	}

	@Given("Enter the Lastname as (.*)$")
	public void enterLastname(String individualName) {
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(individualName);
	}

	@When("Click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

	@Then("Individual created successfully (.*)$")
	public void individual_created_successfully(String name) {
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		if(text.equalsIgnoreCase(name))
		{
			System.out.println("Individual created successfully : " + text);
		}
		
		else
		{
			System.out.println("Problem with the new Individual creation");
		}

	}

	

}
