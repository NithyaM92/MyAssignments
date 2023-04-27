package step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditIndividualStepdefinition extends BaseClass {

	@When("Enter Individual name in search box to edit (.*)$")
	public void enter_individual_name_in_search_box_to_edit_then_click_enter(String IndividualName) throws InterruptedException {
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(IndividualName);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@And("Choose Edit option for the selected first Individual")
	public void choose_edit_option_for_the_selected_first_individual() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
	}

	@Then("Edit Individual form opened")
	public void edit_individual_form_opened() {
		String title = driver.getTitle();
	    System.out.println(title);
	}

	@Given("Choose Salutation as (.*)$")
	public void choose_salutation_as_mr(String option) {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='" + option + "']")).click();
	}

	@And("Enter FirstName as (.*)$")
	public void enter_first_name_as_subi_v(String fName) {
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fName);
	}

	@And("Click on Save")
	public void click_on_save() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
	}

	@Then("Verify Name changed successfully (.*)$")
	public void verify_name_changed_successfully_subi_v(String fName) {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		  	
			String text = driver.findElement(By.xpath("(//a[@data-refid='recordId'])[1]")).getText();
			System.out.println(text);
			if(text.contains(fName))
			{
				System.out.println("Edit action successfull : " + text);
			}
			else
			{
				System.out.println("Problem with the Edit opertaion");
			}
	}

	
}
