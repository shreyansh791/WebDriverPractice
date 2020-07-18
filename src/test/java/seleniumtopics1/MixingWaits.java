package seleniumtopics1;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingWaits {
	/**
	 * 
	 * The below code is the demonstration on the consequences when implicit and explicit wait are mixed. 
	 */
public static void main(String[] args) {
	//WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
	
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.pollingEvery(Duration.ofSeconds(1));
	wait.ignoring(NoSuchElementException.class);
	
	System.out.println("Wait starts:"+new Date());
	try {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wrongElement")));
	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("wrong element"))));
	}catch (Exception e) {
	System.out.println("Unable to locate element." + e.getMessage());
	}

	System.out.println("Wait ends:"+new Date());
	driver.close();
	driver.quit();
}
}
