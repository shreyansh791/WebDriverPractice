package seleniumtopics1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Java8WithSelenium {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		isPageLoaded();
		boolean elementDisplayed = isElementDisplayed();
		System.out.println(elementDisplayed);
		
	}
	public static void isPageLoaded() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 60).until((ExpectedCondition<Boolean>) driver -> {

			String status = js.executeScript("return document.readyState").toString();
			System.out.println("Page Load Status - " + status);
			return js.executeScript("return document.readyState").equals("complete");
		});

	}
	
	public static boolean isElementDisplayed() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return new WebDriverWait(driver, 60).until(driver -> {

			return driver.findElement(By.name("q")).isDisplayed();
		});

	}

}
