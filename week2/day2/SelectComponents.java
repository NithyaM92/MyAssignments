package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/select.xhtml");
		Thread.sleep(1000);
		WebElement toolElement = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select toolSel = new Select(toolElement);
        toolSel.selectByVisibleText("Selenium");
        
        driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
        driver.findElement(By.xpath("//li[text()='India']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Select City']")).click();
        driver.findElement(By.xpath("//li[@data-label='Chennai']")).click();
        
        driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[text()='JMeter']")).click();
        
        driver.findElement(By.id("j_idt87:lang")).click();
        driver.findElement(By.id("j_idt87:lang_1")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='j_idt87:value']")).click();
        driver.findElement(By.xpath("//li[text()='Two']")).click();
        System.out.println("Select componenets completed successfully");
    
        
        
	}

}
