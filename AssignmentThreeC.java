package SeleniumBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentThreeC {

	public static void main(String[] args) throws InterruptedException {
		
		//Third Question
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
						
		Thread.sleep(10000);
		
		System.out.println("---Windows Handling---");
		WebElement clickGotIt = driver.findElement(By.xpath("//button[text()='GOT IT']"));
		clickGotIt.click();
		
		String handleOne = driver.getWindowHandle();
		System.out.println("Current window "+ handleOne);
		
		Thread.sleep(3000);
		
		WebElement clickCognizant = driver.findElement(By.xpath("//img[contains(@src, '/cognizant-hs-tp-21sep2018.gif') ]"));
		clickCognizant.click();
		
		Set <String> allHandles = driver.getWindowHandles();
		List <String> allHandlesList = new ArrayList<>(allHandles);
		
		driver.switchTo().window(allHandlesList.get(1));
		System.out.println("Title of New window "+ driver.getTitle());
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();
	}
}