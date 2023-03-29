package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://in.bookmyshow.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//span[@id='4']")).click();
       driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("sir");
       driver.findElement(By.xpath("//div[@class='sc-fFTYTi kXEckc']")).click();
       Thread.sleep(1000);
       driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
       System.out.println(driver.findElement(By.xpath("//a[@class='__venue-name']")).getText());
       driver.findElement(By.xpath("//div[@class='venue-info-text']")).click();  
       String str = driver.findElement(By.xpath("//div[contains(text(),'Parking Facility')]")).getText();
       if(str.contains("Parking Facility"))
       {
    	   System.out.println("Parking Facility available");
       }

     driver.findElement(By.xpath("//div[@class='cross-container']")).click();
     //driver.findElement(By.id("btnPopupAccept")).click();
     //driver.findElement(By.xpath("(//div[@class='showtime-pill-container _available']//div[@class='__text'])[3]")).click();
    Thread.sleep(500);
     driver.findElement(By.xpath("//div[@class='showtime-pill-container _available']/a")).click();
    driver.findElement(By.id("btnPopupAccept")).click();
     driver.findElement(By.xpath("//ul[@id='popQty']/li")).click();
     driver.findElement(By.id("proceed-Qty")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//a[@class='_available']")).click();
     driver.findElement(By.id("btmcntbook")).click();
     /* String str1 = driver.findElement(By.xpath("//li[@class='_total-section']//span")).getText();    
    
     System.out.println(str1);
    // System.out.println(driver.findElement(By.xpath("//li[@class='_total-section']//span")).getAttribute("span"));
     System.out.println("Total amount is : " + driver.findElement(By.xpath("//li[@class='_total-section']//span[@id='subTT']")).getText());
     System.out.println("Total amount is : " + driver.findElement(By.xpath("//li[@class='_total-section']//span[@id='subTT']")).getAttribute("innerText"));

     System.out.println(driver.findElement(By.xpath("//li[@class='_total-section']//span[@id='subTT']")).getAttribute("innerText"));
     System.out.println(driver.findElement(By.xpath("//span[text()='Rs.229.50']")).getAttribute("textContent")); */
    String text = driver.findElement(By.xpath("//li[@class='_total-section']//span[@id='subTT']")).getText();
   System.out.println(text);
   Thread.sleep(1000);
   System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getText());
   /*System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getAttribute("innerText"));
   System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getAttribute("innerText"));
    
     System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getAttribute("textContent"));
     System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getAttribute("outerText"));
     System.out.println("Total amount is :" + driver.findElement(By.xpath("//span[@id='subTT']")).getAttribute("value"));
     System.out.println("Total amount is :" + driver.findElement(By.xpath("//ul[@class='__details']//span[@id='subTT']")).getAttribute("innerText")); */
     
	}

}
