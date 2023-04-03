package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IRCTC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String parentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//div[@class='iconsection']//label[text()='FLIGHTS']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(1));
        System.out.println("Child window title is : " + driver.getTitle());
        File flightScreen = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/flightScreen.png");
        FileUtils.copyFile(flightScreen, destination);
        System.out.println("done");

	}

}
