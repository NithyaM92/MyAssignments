package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println(text);
        if(text.contains("OK"))
        {
        	System.out.println("Proceed OK");
        }
        else
        {
        	System.out.println("Proceed cancel");
        }

	}

}
