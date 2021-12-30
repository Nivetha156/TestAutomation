package SeleniumBasics;

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
				
		Thread.sleep(10000);
		
		System.out.println("Confirm Popup");
		WebElement clickGotIt = driver.findElement(By.xpath("//button[text()='GOT IT']"));
		clickGotIt.click();
		Thread.sleep(7000);
		String HeaderText = driver.findElement(By.xpath("//p[@class='caption']")).getText();
		System.out.println("Header text: "+ HeaderText);
		String SubText = driver.findElement(By.xpath("//p[@class='desc']")).getText();
		System.out.println("Sub text: "+ SubText);
				
		//Click Sure
		/*
		WebElement clickSure = driver.findElement(By.xpath("//span[contains(text(), 'Sure')]"));
		clickSure.click();
		Thread.sleep(2000);
		System.out.println("I Clicked Sure");
		*/
				
		//Click Later
		WebElement clickLater = driver.findElement(By.xpath("//span[contains(text(), 'Later')]"));
		clickLater.click();
		Thread.sleep(2000);
		System.out.println("I Clicked Later");
						
		driver.close();
		driver.quit();
	}

}
