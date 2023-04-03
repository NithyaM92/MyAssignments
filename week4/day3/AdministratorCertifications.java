package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//span[text()='Learn More']")).click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
        driver.switchTo().window(windowHandlesList.get(1));
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        //Thread.sleep(1000);
        Shadow sha=new Shadow(driver);
        //sha.setImplicitWait(100);
        sha.findElementByXPath("//span[text()='Learning']").click();
        WebElement learningOnTrailhead = sha.findElementByXPath("//span[text()='Learning on Trailhead']");
        Actions act = new Actions(driver);
        act.moveToElement(learningOnTrailhead).perform();
        sha.findElementByXPath("//a[text()='Salesforce Certification']").click();
        String text = driver.findElement(By.xpath("//div[text()='Certification']/following::div[@class='credentials-card_title']")).getText();
        System.out.println("First Administrator certification displayed is : " +text);
        String title = driver.getTitle();
        System.out.println("Title of the page is : " +title);
        if(title.contains("Administrator"))
        {
        	System.out.println("Validated");
        }
        
        else
        {
        	System.out.println("Not validated");
        }
        
        List<WebElement> findElements = driver.findElements(By.xpath("//div[text()='Certification']/following::div[@class='credentials-card_title']"));
        
        System.out.println("Administartor Certifications List : ");
        for (int i=0;i<findElements.size();i++) {
        	System.out.println(findElements.get(i).getText());
        	 
			
		}
        WebElement findElement = driver.findElement(By.linkText("Marketing Cloud Administrator"));
        Actions act1 =new Actions(driver);
        act1.scrollToElement(findElement).perform();
        File source = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/certification.png");
        FileUtils.copyFile(source, destination); 
 	}

}
