package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("demoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
        driver.switchTo().window(windowHandlesList.get(1));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-row')]/table/tbody/tr/td[1]//a)[1]")).click();
        //Thread.sleep(500);
        driver.switchTo().window(windowHandlesList.get(0));
        driver.findElement(By.xpath("(//input[@id='partyIdTo']/following::img)[1]")).click();
        Set<String> windowHandlesSetTo = driver.getWindowHandles();
        List<String> windowHandlesListTo = new ArrayList<String>(windowHandlesSetTo);
        driver.switchTo().window(windowHandlesListTo.get(1));
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-row')]/table/tbody/tr/td[1]//a)[2]")).click();
        driver.switchTo().window(windowHandlesListTo.get(0));
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);
        if(title.contains("View Contact"))
        {
        	System.out.println(" View Contacxt title validated");
        }
        else
        {
        	System.out.println("Please try again , you reached wrong page");
        }
        System.out.println("Completed MergeContact");
        

	}

}
