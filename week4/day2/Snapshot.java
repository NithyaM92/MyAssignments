package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.ajio.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.findElement(By.xpath("//span[text()='Allow Location']")).click();
        WebElement codElement = driver.findElement(By.xpath("//span[@class='ic-cod']"));    
        Actions builder = new Actions(driver);
        builder.scrollToElement(codElement).perform();
        File codScreen = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/ajiocod.png");
        FileUtils.copyFile(codScreen, destination);
        System.out.println("done");

	}

}
