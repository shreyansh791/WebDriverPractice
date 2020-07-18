package seleniumtopics1;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MixingWaits2 {
	
	public static void main(String[] args) {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1));
		System.out.println("Wait starts:" + new Date());
		try {
			wait.until(ExpectedConditions.elementToBeSelected(By.id("hi")));
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wrongElement")));
			 //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("wrongelement"))));
//			 wait.until(ExpectedConditions.elementToBeClickable(By.id("wrongelement")));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrongelement")));
			 
		} catch (Exception e) {
			System.out.println("Unable to locate element." + e.getMessage());
		}

		System.out.println("Wait ends:" + new Date());
		driver.close();
		driver.quit();
	}
}
