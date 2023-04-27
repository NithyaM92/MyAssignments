package step;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinition extends BaseClass {
	
	@And("Enter Username as {string}")
	public void enter_username_as(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@And("Enter Password as {string}")
	public void enter_password_as(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on Login buuton")
	public void click_on_login_buuton() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
	   String title = driver.getTitle();
	   System.out.println(title);
	}
}
