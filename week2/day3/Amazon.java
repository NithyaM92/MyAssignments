package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//div[@class='nav-search-field ']//input")).sendKeys("Bags");
        driver.findElement(By.xpath("//span[text()=' for boys']")).click();
        System.out.println("Bags for Boys total results:");
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText());
        System.out.print(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[3]")).getText());
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@class='a-dropdown-label']")).click();
        driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
        System.out.println("First displayed Result is:");
        System.out.println(driver.findElement(By.xpath("//h5[@class='s-line-clamp-1']/span")).getText());
        System.out.println(driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span")).getText());
	    System.out.println(driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-offscreen']")).getText());
	    System.out.println("Title of the page is : "+driver.getTitle());
	    Thread.sleep(500);
	    driver.close();
	}

}
