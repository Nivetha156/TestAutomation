package SeleniumBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
						
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("---Windows Handling---");
		WebElement clickGotIt = driver.findElement(By.xpath("//button[text()='GOT IT']"));
		clickGotIt.click();
		
		String handleOne = driver.getWindowHandle();
		System.out.println("Current window "+ handleOne);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement clickCognizant = driver.findElement(By.xpath("//img[contains(@src, '/cognizant-hs-tp-21sep2018.gif') ]"));
		clickCognizant.click();
		
		Set <String> allHandles = driver.getWindowHandles();
		List <String> allHandlesList = new ArrayList<>(allHandles);
		
		driver.switchTo().window(allHandlesList.get(1));
		System.out.println("Title of New window "+ driver.getTitle());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();
	}
}
