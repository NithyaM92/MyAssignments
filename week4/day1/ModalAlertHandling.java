package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ModalAlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Alert (Simple Dialog)");
        driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
        Alert simpleAlert = driver.switchTo().alert();
        String simpleAlerttext = simpleAlert.getText();
        System.out.println("Simple Alert text is : "+simpleAlerttext );
        simpleAlert.accept();
        String resultText = driver.findElement(By.id("simple_result")).getText();
        if(resultText.contains("success"))
        {
        	System.out.println("Clicked successfully");
        }
        else
        {
        	System.out.println("Not clicked");
        }
        System.out.println("Alert (Confirm Dialog)");
        driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
        Alert confirmAlert = driver.switchTo().alert();
        String text = confirmAlert.getText();
        System.out.println(text);
        confirmAlert.accept();
        String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
        if(text2.contains("OK"))
        {
        	System.out.println("Success");
        }
        else
        {
        	System.out.println("Fail");
        }
        System.out.println("Sweet Alert (Simple Dialog)");
        driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
        Alert sweetAlert = driver.switchTo().alert();
        String text3 = sweetAlert.getText();
        System.out.println(text3);
        sweetAlert.dismiss();
       
	}

}
