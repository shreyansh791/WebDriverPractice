package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-infobars");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.facebook.com/");
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement firstName = driver.findElement(By.name("firstname"));

		WebElement lastName = driver.findElement(By.name("lastname"));
		enterDate(driver, firstName, 10, "Shreyansh");
		enterDate(driver, lastName, 10, "Jain");
	}

	public static void enterDate(WebDriver driver, WebElement element, int timeOutInSeconds, String valueToBeEntered) {
		// Explicit Wait
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));

		element.sendKeys(valueToBeEntered);

	}

	public static void clickOn(WebDriver driver, WebElement element, int timeOutInSeconds, String valueToBeEntered) {
		// Explicit Wait
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));

		element.click();

	}
}
