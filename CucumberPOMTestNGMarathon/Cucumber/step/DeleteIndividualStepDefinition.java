package step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteIndividualStepDefinition extends BaseClass{
	
	@When("Enter Individual name in search box to delete (.*)$")
	public void enter_individual_name_in_search_box_to_delete(String individualName) throws InterruptedException {
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(individualName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@When("Choose Delete option for the selected Individual")
	public void choose_delete_option_for_the_selected_individual() throws InterruptedException {
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']//a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);////div[@class='uiPopupTrigger']
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
	}

	@Then("Delete Individual form opened")
	public void delete_individual_form_opened() {
	   String title = driver.getTitle();
	   System.out.println(title);
	}

	@Then("Click Delete option")
	public void click_delete_option() {
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
	}

	@Then("Verify Individual deleted successfully (.*)$")
	public void verify_individual_deleted_successfully(String individualname) throws InterruptedException {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("SubiV",Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		//Verify Whether Individual is Deleted using Individual last name"
       System.out.println(verify);
	}

	

}
