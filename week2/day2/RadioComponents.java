package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.leafground.com/radio.xhtml");
		
		String favoriteBrowser = driver.findElement(By.xpath("//label[text()='Chrome']")).getText();
		driver.findElement(By.xpath("//label[text()='Chrome']")).click();
		System.out.println("Your most favorite browser : " + favoriteBrowser);
		
		String location = driver.findElement(By.xpath("//label[text()='Chennai']")).getText();
		driver.findElement(By.xpath("//label[text()='Chennai']")).click();
		System.out.println("UnSelectable location first selection : " + location);
		Thread.sleep(1000);
		location = driver.findElement(By.xpath("//label[text()='Bengaluru']")).getText();
		driver.findElement(By.xpath("//label[text()='Bengaluru']")).click();
		System.out.println("UnSelectable location second selection : " + location);
		String defaultSelect = driver.findElement(By.xpath("//h5[text()='Find the default select radio button']/following::input[@checked='checked']/following::label")).getText();
		System.out.println("Find the default select radio button : " + defaultSelect);
		
		boolean selected = driver.findElement(By.xpath("//h5[text()='Select the age group (only if not selected)']/following::input[@checked='checked']")).isSelected();
		if(selected)
		{
			System.out.println("Select the age group (only if not selected) - Selected ");
			
		}
		else
		{
			System.out.println("Select the age group (only if not selected) - Not Selected ");
		}
		System.out.println("Radio components completed successfully");
		
	}

}
