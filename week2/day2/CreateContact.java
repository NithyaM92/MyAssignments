package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("FirstnameTest");
		driver.findElement(By.id("lastNameField")).sendKeys("LastnameTest");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("FirstnameLocaltest");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("LastnameLocalTest");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Test Description");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testemail@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select sel = new Select(state);
		sel.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		//driver.findElement(By.xpath("updateContactForm_description")).sendKeys("Update Test Description");
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Update Important note");
		driver.findElement(By.xpath("//td[@colspan='4']/input[@class='smallSubmit']")).click();
		System.out.println("Title of the page is : "+driver.getTitle());
	}
}
