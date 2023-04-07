package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonMobiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles",Keys.ENTER);
        List<WebElement> priceWeb = driver.findElements(By.className("a-price-whole"));
        List<Integer> priceIntegerList = new ArrayList<Integer>();
        for (WebElement each : priceWeb) {
        	String priceString = each.getText();
        	String priceStringInt = priceString.replaceAll(",", "");
        	if(!priceStringInt.isEmpty()) {
        	int priceInt = Integer.parseInt(priceStringInt);
			priceIntegerList.add(priceInt);
        	}
		}
        Collections.sort(priceIntegerList);
        System.out.println(priceIntegerList);
        System.out.println("Lowest price is : " + priceIntegerList.get(0));
        
	}

}
