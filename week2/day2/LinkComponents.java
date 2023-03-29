package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Take me to dashboard");
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]")).click();
		String title = driver.getTitle();
		if(title.contains("Dashboard"))
		{
			System.out.println("Dashboard page confirmed");
		}
		else
		{
			System.out.println("Dashboard page not confirmed");
		}
		driver.navigate().back();
		System.out.println("Find my destination");
		String link = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']")).getAttribute("href");
		System.out.println(link);
		System.out.println("Am I broken link?");
		driver.findElement(By.xpath("//a[text()='Broken?']")).click();
		String brokenTitle = driver.getTitle();
		System.out.println("Broken title is " + brokenTitle);
		if(brokenTitle.contains("404"))
		{
			System.out.println("Broken");
		}
		else
		{
			System.out.println("Not Broken");
		}
		driver.navigate().back();
		System.out.println("Duplicate Link");
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[2]")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println("Count Links");
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		int size = findElements.size();
		System.out.println(size);
		System.out.println("Count Layout Links");
		driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
		List<WebElement> findElements2 = driver.findElements(By.tagName("a"));
		int size2 = findElements2.size();
        System.out.println(size2);
        System.out.println("Link components completed successfully");
	}

}
