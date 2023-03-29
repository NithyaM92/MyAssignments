package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;

public class InputComponents {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Type your name");
        driver.findElement(By.xpath("(//h5[text()='Type your name']/following::input)[1]")).sendKeys("Nithya M");
        System.out.println("Append Country to this City.");
        driver.findElement(By.xpath("(//h5[text()='Append Country to this City.']/following::input)[1]")).sendKeys("Trichy");
        System.out.println("Verify if text box is disabled");
        boolean enabled = driver.findElement(By.xpath("(//h5[text()='Verify if text box is disabled']/following::input)[1]")).isEnabled();
        System.out.println(enabled);
        if(enabled)
        {
        	System.out.println("Text box enabled");
        }
        else
        {
        	System.out.println("Text box disabled");
        }
        System.out.println("Clear the typed text.");
        driver.findElement(By.xpath("(//h5[text()='Clear the typed text.']/following::input)[1]")).clear();
        System.out.println("Retrieve the typed text.");
        String text = driver.findElement(By.xpath("(//h5[text()='Retrieve the typed text.']/following::input)[1]")).getAttribute("placeholder");
	    System.out.println(text);
	    System.out.println("Type email and Tab. Confirm control moved to next element.");
	    driver.findElement(By.xpath("(//h5[text()='Type email and Tab. Confirm control moved to next element.']/following::input)[1]")).sendKeys("testleaf@mail.com",Keys.TAB);
	    WebElement activeElement = driver.switchTo().activeElement();
	    String text2 = activeElement.getText();
	    if(text2.contains("About yourself"))
	    { 
	    	System.out.println("Control moved successfully");	    	
	    }
	    else
	    {
	    	System.out.println("Control not moved");
	    }
	    activeElement.sendKeys("Automation tester");
	    driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("TestLeaf");
	    System.out.println("Just Press Enter and confirm error message*");
	    driver.findElement(By.xpath("(//h5[text()='Just Press Enter and confirm error message*']/following::input)[2]")).sendKeys(Keys.ENTER);
	    String text3 = driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).getText();
	    System.out.println(text3);
	    if(text3.contains("Age is mandatory"))
	    {
	    	System.out.println("Error message displayed successfully");
	    	
	    }
	    else
	    {
	    	System.out.println("Error message not displayed");
	    }
        System.out.println("Click and Confirm Label Position Changes");
        WebElement floatElement = driver.findElement(By.xpath("//label[text()='Username']"));
        Point location = floatElement.getLocation();
        System.out.println(location);
        Thread.sleep(500);
        driver.findElement(By.xpath("(//h5[text()='Click and Confirm Label Position Changes']/following::input)[1]")).click();
        Point location2 = floatElement.getLocation();
        System.out.println(location2);
        
        if(location.equals(location2))
        {
        	System.out.println("Position not changed");
        }
        else
        {
        	System.out.println("Position changed");
        }
	    
        System.out.println("Type your name and choose the third option");
        /*driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']/following::input")).sendKeys("TestLeaf");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='ui-autocomplete-query'])[3]")).click();*/
        
        WebElement type = driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']/following::input"));
        type.sendKeys("TestLeaf");
        Thread.sleep(3000);
        WebElement select = driver.findElement(By.xpath("(//span[@class='ui-autocomplete-query'])[1]"));
        Actions builder = new Actions(driver);
    	builder.moveToElement(select).perform();
        Thread.sleep(3000);
        for(int i=0;i<3;i++) {
        	type.sendKeys(Keys.DOWN);
        }
        type.sendKeys(Keys.ENTER);
        
        System.out.println("Type your DOB (mm/dd/yyyy) and confirm date chosen");
        driver.findElement(By.xpath("(//h5[text()='Type your DOB (mm/dd/yyyy) and confirm date chosen ']/following::input)[1]")).sendKeys("02/07/1992");
        
        System.out.println("Type number and spin to confirm value changed");
        WebElement numberSpin = driver.findElement(By.xpath("(//h5[text()='Type number and spin to confirm value changed']/following::input)[1]"));
        numberSpin.sendKeys("10");
        String text4 = numberSpin.getAttribute("value");
        System.out.println("Before spin : " +text4);
        driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-s']")).click();
        String text5 = numberSpin.getAttribute("value");
        System.out.println("After spin : " +text5);
        if(text4.equals(text5))
        {
        	System.out.println("Value not changed");
         }
        else
        {
        	System.out.println("Value changed after spin");
        }
        System.out.println("Type random number (1-100) and confirm slider moves correctly");
        WebElement spin = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
        Point beforeSpin = spin.getLocation();
        System.out.println("Before number entering location :" + beforeSpin);
        driver.findElement(By.xpath("(//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input)[1]")).sendKeys("75");
        Point afterSpin = spin.getLocation();
        System.out.println("After number entering location :" + afterSpin);
        if(beforeSpin.equals(afterSpin))
        {
        	System.out.println("Slider not changed");
        }
        else
        {
        	System.out.println("slider changed");
        }
        System.out.println("Click and Confirm Keyboard appears");
        driver.findElement(By.xpath("//h5[text()='Click and Confirm Keyboard appears']/following::input")).click();
        boolean displayed = driver.findElement(By.xpath("//div[contains(@class,'ui-shadow keypad-popup ui-input-overlay')]")).isDisplayed();
        if(displayed)
        {
        	System.out.println("Keyboard displayed");
        }
        else
        {
        	System.out.println("Keyboard not displayed");
        }
        System.out.println("Custom Toolbar");
        driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("TestLeaf custom");
        System.out.println("Input Componenets processed successfully");
	}

}
