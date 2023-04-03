package week4.day1;

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

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String priceFirstProductStr = driver.findElement(By.xpath("//span[@class='a-price']//span[@class='a-price-whole']")).getText();
        priceFirstProductStr = priceFirstProductStr.replace(",", "");
        double priceFirstProduct = Double.parseDouble(priceFirstProductStr);
        System.out.println("First product price is : " + priceFirstProduct );
        Thread.sleep(500);
        String ratingFirstProduct = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
        System.out.println("First product rating is : "+ratingFirstProduct );
        driver.findElement(By.xpath("//img[@class='s-image']")).click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet); 
        driver.switchTo().window(windowHandlesList.get(1));
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        Actions act = new Actions(driver);
        act.moveToElement(addToCart).perform();
        File soruce = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File ("./snaps/oneplus.png");
        FileUtils.copyFile(soruce, destination);
        addToCart.click();
        Thread.sleep(6000);
        //driver.findElement(By.xpath("//input[@class='a-button-input']/following::span[text()=' Cart ']")).click();
        //driver.findElement(By.id("attach-close_sideSheet-link")).click();
        String cartSubTotalStr = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
        //cartSubTotalStr = cartSubTotalStr.replaceAll("\\D", "");
        cartSubTotalStr = cartSubTotalStr.replace("₹", "");
        cartSubTotalStr = cartSubTotalStr.replace(",", "");
        System.out.println(cartSubTotalStr);
        double cartSubTotal = Double.parseDouble(cartSubTotalStr);
        System.out.println("cart SubTotal amount is: " + cartSubTotal);
        if(priceFirstProduct==cartSubTotal)
        {
        	System.out.println("Initial and final price are matching and the price is :" +cartSubTotal);
        }
        else
        {
        	System.out.println("Initial and final price are not matching");
        }
        System.out.println("completed");
        driver.close(); 
	}

}
