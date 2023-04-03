package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowComponents {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://leafground.com/window.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String parent = driver.getWindowHandle();
        System.out.println("Parent window is : "+parent);
        System.out.println("Click and Confirm new Window Opens");
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
        int windowSize = windowHandlesList.size();
        if(windowSize>0)
        {
        	System.out.println("Another window opened");      	
        }
        else
        {
        	System.out.println("No new page identified");
        }
        driver.switchTo().window(windowHandlesList.get(1));
        System.out.println("Title of the new page is :"+ driver.getTitle());
        driver.switchTo().window(windowHandlesList.get(0));
        
        System.out.println("Find the number of opened tabs");
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> windowHandlesMultiple = driver.getWindowHandles();
        //List<String> windowHandlesMultipleList = new ArrayList<String>(windowHandlesMultiple);
        
        System.out.println("Windows opened count is : " + windowHandlesMultiple.size());
        driver.switchTo().window(parent);
        
        System.out.println("Close all windows except Primary");
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        
        Set<String> windowHandlesClose1 = driver.getWindowHandles();
        List<String> windowHandlesCloseList = new ArrayList<String>(windowHandlesClose1);
        for (int i = 0; i < windowHandlesCloseList.size(); i++) {
           	if(i!=0)
        	{
        		driver.switchTo().window(windowHandlesCloseList.get(i));
        		driver.close();
        	    System.out.println("window closed " +i);
        	}
        	else
        	{
        		System.out.println("As it's parent window, not closing");
        	}
        }	
        driver.switchTo().window(parent);
        System.out.println("Wait for 2 new tabs to open");
        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
	    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	    
	    driver.switchTo().window(parent);
	    System.out.println("Window components processed successfully");
        
	}

}
