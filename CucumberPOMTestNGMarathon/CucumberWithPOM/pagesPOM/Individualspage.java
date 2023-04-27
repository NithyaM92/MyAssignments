package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesPOM.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Individualspage extends BaseClass {
	
	public Individualspage()
	{
		
	}
	
	public Individualspage(ChromeDriver driver)
	{
		this.driver = driver;
	}

	@And ("click on Individual dropdown in the next page")
	public Individualspage clickIndividualdropdown()
	{
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		return this;
	}
	
	@And ("click on New Individual option")
	public Individualspage clickNewIndividual()
	{
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", clk);
		return this;
	}
	
	@Then("New Individual screen form wil be displayed")
	public Individualspage verifyNewIndividualForm()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return this;
	}
	
	@Given ("Enter the Lastname as (.*)$")
	public Individualspage enterLastNameinForm(String individualname)
	{
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(individualname);
		return this;
	}
	
	@When("Click on save button")
	public ViewIndividualPage clickSave()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new ViewIndividualPage(driver);
	}
	
	
	@And ("Enter Individual name in search box to edit (.*)$")
	public Individualspage searchIndividualforEdit(String Individualname) throws InterruptedException
	{
		
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(Individualname, Keys.ENTER);
		//name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
		
	}
	
	@And("Choose Edit option for the selected first Individual")
	public Individualspage chooseEditaction() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		return this;
	}
	
	@Then("Edit Individual form opened")
	public Individualspage verifyEditIndividualform()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return this;
	}
	
	@Given("Choose Salutation as (.*)$")
	public Individualspage chooseSalutation(String option)
	{
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]")).click();
		return this;
	}
	
	@And("Enter FirstName as (.*)$")
	public Individualspage enterFirstName(String fName)
	{
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fName);
		return this;
		
	}
	
	@And ("Click on Save for Edit Action")
	public Individualspage clickSaveforEdit() throws InterruptedException
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		return this;
	}
	
	@Then ("Verify Name changed successfully (.*)$")
	public Individualspage verifyEditaction(String fName) {
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
			return this;
			
	}	
	
	@And("Enter Individual name in search box to delete (.*)$")
	public Individualspage searchIndividualDelete(String individualName) throws InterruptedException
	{
		WebElement name = driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(individualName, Keys.ENTER);
		//name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		return this;
	}
	
	@And("Choose Delete option for the selected Individual")
	public Individualspage chooseDeleteaction() throws InterruptedException
	{
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']//a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);////div[@class='uiPopupTrigger']
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(3000);
		return this;
	}
	
	@Then("Delete Individual form opened")
	public Individualspage verifyDeleteIndiviualform()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return this;
	}
	
	@And("Click Delete option")
	public Individualspage clickDelete()
	{
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		return this;
	}
	
	@Then("Verify Individual deleted successfully (.*)$")
	public Individualspage verifyDeleteaction(String individualName) throws InterruptedException
	{
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(individualName,Keys.ENTER);
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		//Verify Whether Individual is Deleted using Individual last name"
      System.out.println(verify);
      return this;
	}
	
}
