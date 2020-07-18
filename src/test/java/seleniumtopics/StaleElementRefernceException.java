package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class StaleElementRefernceException {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().setSize(new Dimension(1200, 1280));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement findElement = driver.findElement(By.name("username"));
		try {
			driver.navigate().refresh();
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		findElement.sendKeys("hiiiiiiiiiiiiiiiii");
		}catch (StaleElementReferenceException e) {
			System.out.println("In Catch");
			getElement(By.name("username")).sendKeys("yoooo");
		}
		
	}
	/*public static WebElement getElement(By locator)
	{
		try {
			// Check visibility. If reference is not stale, it will return the same referenced. Otherwise it will go to catch.
			WebElement element = driver.findElement(locator);
			element.isDisplayed();
			return element;
			
			// Relocate element in catch and return
		}catch(StaleElementReferenceException e)
		{
			System.out.println("Catch.............");
			return driver.findElement(locator);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}*/
	public static WebElement getElement(By locator)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(java.time.Duration.ofSeconds(1));
		wait.withTimeout(java.time.Duration.ofSeconds(20));
		wait.ignoring(StaleElementReferenceException.class);// We need to ignore this exception.

		Function<WebDriver, WebElement> function = driver ->
		{
				System.out.println("Checking for the object!!");
				WebElement element = driver.findElement(locator);
				if (element != null) {
					System.out.println("object is found.");
				}
				return element;
				
			
		};
		 return wait.until(function);
	}
}
