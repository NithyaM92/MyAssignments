package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ButtonComponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/button.xhtml");
		System.out.println("Click and Confirm title.");
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm title.']/following::button)[1]")).click();
		System.out.println("Title is : " +driver.getTitle());
		driver.navigate().back();
		System.out.println("Confirm if the button is disabled");
		boolean disabledAttribute = driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled();
		System.out.println(disabledAttribute);
		if(!disabledAttribute)
		{
			System.out.println("Button is not enabled." );
		}
		else
		{
			System.out.println("Button is enabled");
		}
		System.out.println("Find the position of the Submit button");
		Point submitLocation = driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/following::span[text()='Submit']")).getLocation();
		System.out.println("Submit button location is :" + submitLocation);
		
		System.out.println("Find the Save button color");
	    String colorValue = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("color");
	    System.out.print(colorValue);
	    
	    System.out.println("Find the height and width of this button");
	    Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.print(size);
		
		System.out.println("Mouse over and confirm the color changed");
		WebElement successElement = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));
		String beforeCSS = successElement.getCssValue("background-color");
		System.out.println("Before perform mouse over color :" +beforeCSS );
		Actions builder = new Actions(driver);
		builder.moveToElement(successElement).perform();
		String afterCSS = successElement.getCssValue("background-color");
		System.out.println("After perform mouse over color :" +afterCSS);
		if(beforeCSS.equalsIgnoreCase(afterCSS)){
			System.out.println("Color not changed");
		}
		else
		{
			System.out.println("Color changed");
		}

		System.out.println("Click Image Button and Click on any hidden button");
		driver.findElement(By.xpath("(//span[text()='Image'])")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='card ui-fluid']")).click();
		driver.findElement(By.xpath("(//span[text()='Image'])")).click();
		System.out.println("How many rounded buttons are there?");
		List<WebElement> roundButtonElements = driver.findElements(By.xpath("//button[contains(@class,'rounded')]"));
		int size1 = roundButtonElements.size();
		System.out.println(size1);
		System.out.println("Button components completed successfully");

	}

}
