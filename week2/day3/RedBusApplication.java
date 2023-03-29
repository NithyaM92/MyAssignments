package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class RedBusApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("chennai");
        driver.findElement(By.xpath("//li[text()='Chennai']")).click();
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("bangalore");
        driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
        driver.findElement(By.id("onward_cal")).click();
        driver.findElement(By.xpath("//td[@class='wd day']")).click();
        driver.findElement(By.id("search_btn")).click();
        System.out.println("Initial results:");
        System.out.println(driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText());
        System.out.println("After Sleeper coach chosen:");
        driver.findElement(By.xpath("(//label[@class='custom-checkbox'])[6]")).click();
        System.out.println(driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText());
        System.out.println("Title of the page is" + driver.getTitle());
	}
}
