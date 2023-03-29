package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLeadusingXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps"); 
		driver.manage().window().maximize(); 
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager"); 
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa"); 
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click(); 
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click(); //driver.findElement(By.name("USERNAME")).sendKeys("demoSalesManager"); //driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa"); //driver.findElement(By.className("loginButton")).click(); // Thread.sleep(2000); driver.findElement(By.xpath("//a[text()='Leads']")).click();
		/*driver.findElement(By.name("USERNAME")).sendKeys("DemoCSR");
         driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		 driver.findElement(By.className("loginButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tester1");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Last1");
		driver.findElement(By.name("submitButton")).click();*/

	}

}
