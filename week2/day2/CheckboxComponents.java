package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckboxComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		driver.findElement(By.xpath("//label[text()='Others']")).click();
		driver.findElement(By.xpath("//label[text()='Python']")).click();
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		
		driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[contains(@class,'ui-chkbox-box ui-widget ui-corner-all ui-state-default')]")).click();
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		boolean enabled = driver.findElement(By.xpath("//h5[text()='Verify if check box is disabled']/following::div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget']//input")).isEnabled();
		if(!enabled)
		{
			System.out.println("Checkbox is disabled");
		}
		else
		{
			System.out.println("Checkbox enabled");
		}
        
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Barcelona'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Miami'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Amsterdam'])[2]")).click();
		driver.findElement(By.xpath("//a[@class='ui-selectcheckboxmenu-close ui-corner-all']")).click();
		System.out.println("Checkbox components completed successfully");
	}

}
