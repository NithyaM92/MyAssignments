package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaApplication {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement Brands = driver.findElement(By.linkText("Brands"));
        Actions act = new Actions(driver);
        act.moveToElement(Brands).perform();
        driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
        driver.findElement(By.linkText("L'Oreal Paris")).click();
        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);
        if(title.contains("L'Oreal Paris"))
        {
        	System.out.println("Reached to the exact page");
        }
        else
        {
        	System.out.println("Try again");
        }
        driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        driver.findElement(By.xpath("//span[text()='Hair']")).click();
        driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
        Thread.sleep(500);
        String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
        if(filter.contains("Shampoo")) {
        	System.out.println("Filter applied perfectly with " + filter);	
        }
        else
        {
        	System.out.println("Filter not applied");

        }
        driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet); 
        driver.switchTo().window(windowHandlesList.get(1));
        driver.findElement(By.xpath("//span[text()='180ml']")).click();
        String priceStr = driver.findElement(By.xpath("(//span[text()='MRP:']/following::span)[1]")).getText();
        priceStr = priceStr.replaceAll("[^0-9]", "");
        int price = Integer.parseInt(priceStr);
        System.out.println("Price of the product in details page is :" + price);
        driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
        driver.findElement(By.xpath("(//*[name()='svg' and @viewBox='0 0 24 24' and @width='24' and @height='24'])[6]")).click();
	    driver.switchTo().frame(0);
        String grandTotalStr = driver.findElement(By.xpath("//div[contains(@class,'footer-layout')]//span")).getText();
        grandTotalStr = grandTotalStr.replaceAll("[^0-9]", "");
        int grandTotal = Integer.parseInt(grandTotalStr);
        System.out.println("Grand total in Bag page : "+ grandTotal);
	    driver.findElement(By.xpath("//div[contains(@class,'footer-layout')]//button")).click();
	    driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	    driver.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
	    Thread.sleep(1000);
	    String grandTotalFinalStr = driver.findElement(By.xpath("(//p[text()='Price Details']/following::p)[1]")).getText();
	    
	    grandTotalFinalStr = grandTotalFinalStr.replaceAll("[^0-9]", "");
        int grandTotalFinal = Integer.parseInt(grandTotalFinalStr);
	    System.out.println("Grand total in payment page : "+ grandTotalFinal);
	    if(grandTotal==grandTotalFinal)
	    {
	    	System.out.println("Price are matching in BAG and payment page and the price is : " + grandTotalFinal );
	    }
	    else
	    {
	    	System.out.println("Price are not matching , contact customer care");
	    }
	    driver.quit();
	}

}
