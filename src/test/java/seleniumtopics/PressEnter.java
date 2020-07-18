package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PressEnter {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("https://www.google.com/");
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.name("q"));
		setTextUsingJS("Trying", ele);
		/*
		 * Actions actions=new Actions(driver);
		 * actions.moveToElement(ele).sendKeys("Selenium",Keys.ENTER).build().perform();
		 */

	}

	public static void setTextUsingJS(String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}
}
