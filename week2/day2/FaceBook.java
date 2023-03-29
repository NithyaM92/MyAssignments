package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        driver.findElement(By.name("firstname")).sendKeys("TestFirst");
        driver.findElement(By.name("lastname")).sendKeys("TestLast");
        driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
        driver.findElement(By.id("password_step_input")).sendKeys("Test@1234");
        WebElement day = driver.findElement(By.xpath("//span[@class='_5k_4']//select[@id='day']"));
        Select sel = new Select (day);
        sel.selectByIndex(7);
        WebElement month = driver.findElement(By.xpath("//span[@class='_5k_4']//select[@id='month']"));
        Select sel1 = new Select (month);
        sel1.selectByValue("2");
        WebElement year = driver.findElement(By.xpath("//span[@class='_5k_4']//select[@id='year']"));
        Select sel2 = new Select (year);
        sel2.selectByVisibleText("2000");
        driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/label")).click();
        System.out.println("Facebook task Completed");
        
        
	}

}
