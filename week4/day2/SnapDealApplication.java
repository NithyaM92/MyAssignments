package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDealApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement category = driver.findElement(By.linkText("Men's Fashion"));
        Actions act = new Actions(driver);
        act.moveToElement(category).perform();
        driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
        String total = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following::div[@class='child-cat-count ']")).getText();
        System.out.println("Sports shoes count is :" + total);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]")).click();
        System.out.println("Prices are ordered from low to High");
        Thread.sleep(1000);
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
        List<String> showPrice = new ArrayList<String>();
        for (int i=0;i<priceElements.size();i++)
        {
        	String priceStr = priceElements.get(i).getText();
        	showPrice.add(priceStr);
        	System.out.println("Price String: "+priceStr);
         /* priceStr = priceStr.replaceAll("\\D", "");
        	int price = Integer.parseInt(priceStr);
        	System.out.println("Price Value: "+price); */
        }
        WebElement fromValue = driver.findElement(By.name("fromVal"));
        fromValue.clear();
        fromValue.sendKeys("500");
        
        WebElement toValue = driver.findElement(By.name("toVal"));
        toValue.clear();
        toValue.sendKeys("600");
        
        driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
        Thread.sleep(1000);
        
        List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='filter-clear']"));
        System.out.println("Total filters applied is : " + findElements.size());
        
        WebElement shoe = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"));
        act.moveToElement(shoe).perform();
        
        driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
       
        String originalPrice = driver.findElement(By.xpath("//div[contains(@class,'product-desc-price')]/span")).getText();
        System.out.println("Original price of the selected shoe is :" +originalPrice );
        
        String discountedPrice = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[contains(@class,'pay')]")).getText();
        System.out.println("Discounted price is : " + discountedPrice);
        
        String discountPercentage = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[@class='percent-desc ']")).getText();
        System.out.println("Discounted percentage is : "+ discountPercentage);
        
        File shoeScreen = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File ("./snaps/snapdeal-shoe.png");
        FileUtils.copyFile(shoeScreen, destination);
        
        driver.findElement(By.xpath("(//div[contains(@class,'close close1 marR10')])[1]")).click();
        driver.close();

	}

}
