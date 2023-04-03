package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://dev57553.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Shadow sha = new Shadow(driver);
        sha.setImplicitWait(30);
        //Thread.sleep(500);
        sha.findElementByXPath("//div[@id='all']").click();
        sha.setImplicitWait(10);
        sha.findElementByXPath("//span[text()='Service Catalog']").click();
        // sha.setImplicitWait(30);
        WebElement frame = sha.findElementByXPath("/iframe[@id='gsft_main']");
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//div[@class='homepage_category_only']//table/tbody/tr/td/a//h2[contains(text(),'Mobiles')]")).click();
        
        driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
        WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
        Select sel = new Select(color);
        sel.selectByVisibleText("Gold");
        WebElement storage = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
        Select sel1 = new Select(storage);
        sel1.selectByVisibleText("128");
        driver.findElement(By.id("oi_order_now_button")).click();
        boolean displayed = driver.findElement(By.xpath("//div[@class='notification notification-success']")).isDisplayed();
        if(displayed)
        {
        	System.out.println(driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText());
        	
        }
        else
        {
        	System.out.println("Sorry, some problem in your order");
        }
        String orderNo = driver.findElement(By.id("requesturl")).getText();
        System.out.println("Order placed successfully and Request ID is : ");
        System.out.println(orderNo);
        File orderScreenshot = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/order.png");
        FileUtils.copyFile(orderScreenshot, destination);
	}

}
