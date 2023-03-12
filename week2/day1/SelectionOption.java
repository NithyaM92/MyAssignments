package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectionOption {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//driver.findElement(By.name("USERNAME")).sendKeys("DemoCSR");
		// driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		// driver.findElement(By.className("loginButton")).click();
		// Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tester1");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Last1");
	    WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select sec = new Select(source);
        sec.selectByIndex(4);
      
        WebElement marketingcampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
        Select sel = new Select(marketingcampaign);
        sel.selectByVisibleText("Automobile");
       
        WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
        Select sel1 = new Select(ownership);
        sel1.selectByValue("OWN_CCORP");
       
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(1000);
		System.out.println("Title os the page is :" + driver.getTitle());
		
		

	}

}
