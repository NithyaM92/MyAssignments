package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[14]")).sendKeys("Tester1");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//driver.findElement(By.xpath("//a[text()='11031']")).click();
		System.out.println("Title of the page is :"+ driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf Update");
		driver.findElement(By.name("submitButton")).click();
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
        if(updatedCompanyName.contains("Test Leaf Update"))
        {
        	System.out.println("Company name updated");
        }
        else
        {
        	System.out.println("Company name not updated");
        }
        driver.close();
	}

}
