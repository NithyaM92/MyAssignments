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

public class ArchitectCertifications {

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
        Thread.sleep(3000);
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
        // driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
        driver.findElement(By.xpath("//img[contains(@alt,'Salesforce<br/>Architect')]")).click();
        String summary = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText();
        System.out.println(summary);
        List<WebElement> certElements = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
        System.out.println("Salesforce Architect Certifications list is : ");
        for (WebElement webElement : certElements) {
			System.out.println(webElement.getText());
		}
        driver.findElement(By.xpath("//div[@class='credentials-card_title']/a[text()='Application Architect']")).click();
        List<WebElement> archElements = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
        System.out.println("\n Application Architect Certifications list is : ");
        for (WebElement webElement : archElements) {
			System.out.println(webElement.getText());
		}
        WebElement scr1 = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[4]"));
        Actions act2 = new Actions(driver);
        act2.moveToElement(scr1).perform();
        File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
        File destination1 = new File("./snaps/Architect Certifications set 1.png");
        FileUtils.copyFile(screenshot1, destination1);
        
        WebElement scr2 = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[9]"));
        
        act2.moveToElement(scr2).perform();
        File screenshot2 = driver.getScreenshotAs(OutputType.FILE);
        File destination2 = new File("./snaps/Architect Certifications set 2.png");
        FileUtils.copyFile(screenshot2, destination2);
        
	}

}
