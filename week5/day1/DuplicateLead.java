package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {
    @Test(groups = "Sanity", invocationCount = 5)
	public void runDuplicateLead() throws InterruptedException {
		// TODO Auto-generated method stub
	/*	ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click(); */
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test_leaf@test.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Thread.sleep(2000);
		String firstName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		System.out.println("Name of the first resulting Lead "+firstName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println("Title of the page is " + title);
		if(title.contains("Duplicate Lead"))
		{
			System.out.println("Reached correctly to create Duplicate Lead");
		}
		else
		{
			System.out.println("Duplicate Lead creation page not found");
		}
		driver.findElement(By.xpath("(//input[@name='primaryPhoneNumber'])[4]")).sendKeys("1234567890");
		driver.findElement(By.name("submitButton")).click();
		String firstNameDuplicate = driver.findElement(By.id("viewLead_firstName_sp")).getText();
       
		System.out.println(firstNameDuplicate);
		System.out.println("success");
		if(firstName.equalsIgnoreCase(firstNameDuplicate))
        {
        	System.out.println("Duplicate lead created successfully and name is " + firstName);
        }
        else
        {
        	System.out.println("Problem with the duplicate lead generation");
        }
       
	}

}
