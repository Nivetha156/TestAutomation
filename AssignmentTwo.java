package SeleniumBasics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssignmentTwo {

	public static void main(String[] args) throws InterruptedException {

		//OpenBrowser
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("http://zero.webappsecurity.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Click sign-in button
		WebElement homeSignInButton = driver.findElement(By.xpath("//button[@type='button']"));
		homeSignInButton.click();
		
		//Enter values into user name text box
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("username");
		
		//Enter values into password text box
		WebElement passWord = driver.findElement(By.id("user_password"));
		passWord.sendKeys("password");
		
		//Click sign-in button
		WebElement signInButton = driver.findElement(By.cssSelector("[value='Sign in']"));
		signInButton.click();
		
		//Handling connection is not secure error
		WebElement advancedButton = driver.findElement(By.id("details-button"));
		if(advancedButton.isDisplayed()) {
		advancedButton.click();
		WebElement proceedAnywayButton = driver.findElement(By.xpath("//*[@id='proceed-link']"));
		proceedAnywayButton.click();
		}
		
		//Click Pay Bills
		WebElement clickPayBills = driver.findElement(By.linkText("Pay Bills"));
		clickPayBills.click();
		
		//Click Add new payee
		WebElement clickNewPayee = driver.findElement(By.partialLinkText("New Payee"));
		clickNewPayee.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter Payee details
		WebElement payeeName = driver.findElement(By.cssSelector("input#np_new_payee_name"));
		payeeName.sendKeys("Zara");
		WebElement payeeAddr = driver.findElement(By.tagName("textarea"));
		payeeAddr.sendKeys("1B,ABC Street, Guindy, Chennai-6");
		WebElement account = driver.findElement(By.xpath("//input[contains(@id,'new_payee_account')]"));
		account.sendKeys("Savings");
		WebElement payeeDetails = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/article[1]/fieldset[1]/div[4]/div[1]/input[1]"));
		payeeDetails.sendKeys("abc");
		
		//Click Add
		WebElement clickAdd = driver.findElement(By.id("add_new_payee"));
		clickAdd.click();
		
		//Logout
		WebElement clickDropDown = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
		clickDropDown.click();
		WebElement clickLogout = driver.findElement(By.cssSelector("a#logout_link"));
		clickLogout.click();
		
		driver.close();
		driver.quit();
		
	}

}
