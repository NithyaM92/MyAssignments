package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
	@BeforeTest (alwaysRun = true)
	public void setValues()
	{
		excelFileName = "EditLead";
	}
	
    @Test(dataProvider = "sendData", groups = "Smoke", dependsOnMethods = "week5.day1.CreateLead.runCreateLead")
    //(dependsOnMethods = {"week5.day1.CreateLead.runCreateLead"})
	public void runEditLead(String pNo, String cName) throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead is editted successfully");
		}
		else {
			System.out.println("Lead is not editted");
		}
		


	}
   /* @DataProvider
    public String[][] sendData() {

       String[][] data = new String[2][2];
       data[0][0] = "99";
       data[0][1] = "CTS";
    		   
       data[1][0] = "91";
       data[1][1] = "WIPRO";
       
       return data;

	}*/

}
