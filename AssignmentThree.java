package SeleniumBasics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentThree {

	public static void main(String[] args) throws InterruptedException {
		
		//First Question
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		
		System.out.println("Normal Popup");
		WebElement homeSignInButton = driver.findElement(By.xpath("//button[@type='button']"));
		homeSignInButton.click();
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("username");
		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys("password");
		WebElement signInButton = driver.findElement(By.cssSelector("[value='Sign in']"));
		signInButton.click();
		
		WebElement advancedButton = driver.findElement(By.id("details-button"));
		if(advancedButton.isDisplayed()) {
		advancedButton.click();
		WebElement proceedAnywayButton = driver.findElement(By.xpath("//*[@id='proceed-link']"));
		proceedAnywayButton.click();
		}
		
		WebElement clickPayBills = driver.findElement(By.linkText("Pay Bills"));
		clickPayBills.click();
		WebElement clickPFC = driver.findElement(By.partialLinkText("Foreign Currency"));
		clickPFC.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement clickPurchase = driver.findElement(By.id("purchase_cash"));
		clickPurchase.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		assertEquals(alertText,"Please, ensure that you have filled all the required fields with valid values.","Failed");
		alert.accept();
		
		WebElement clickDropDown = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
		clickDropDown.click();
		WebElement clickLogout = driver.findElement(By.cssSelector("a#logout_link"));
		clickLogout.click();
		
		driver.close();
		driver.quit();		
		
	}
}
