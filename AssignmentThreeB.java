package SeleniumBasics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentThreeB {

	public static void main(String[] args) throws InterruptedException {
		
		//Second Question
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Confirm Popup");
		WebElement clickGotIt = driver.findElement(By.xpath("//button[text()='GOT IT']"));
		clickGotIt.click();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		String HeaderText = driver.findElement(By.xpath("//p[@class='caption']")).getText();
		System.out.println("Header text: "+ HeaderText);
		String SubText = driver.findElement(By.xpath("//p[@class='desc']")).getText();
		System.out.println("Sub text: "+ SubText);
		
		Assert.assertEquals(HeaderText, "Share your location with Naukri.com for more relevant jobs", "Failed");
		Assert.assertEquals(SubText, "You can turn them off anytime from browser settings", "Failed");
				
		//Click Sure
		/*
		WebElement clickSure = driver.findElement(By.xpath("//span[contains(text(), 'Sure')]"));
		clickSure.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("I Clicked Sure");
		*/
				
		//Click Later
		WebElement clickLater = driver.findElement(By.xpath("//span[contains(text(), 'Later')]"));
		clickLater.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("I Clicked Later");
						
		driver.close();
		driver.quit();
	}

}
