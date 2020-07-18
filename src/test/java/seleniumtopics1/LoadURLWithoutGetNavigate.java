package seleniumtopics1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadURLWithoutGetNavigate {
	public static void main(String[] args) {

		System.out.println("Execution Starts");
		// Setting chrome driver property and opening chrome browser
		// System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opened.");
		// We need to downcast WebDriver reference varaible to use JavascriptExecutor
		// methods
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = "https://www.redbus.in";
		String script = "window.location ='" + url + "'";
		// String script = "window.location ='https://www.redbus.in'";
		js.executeScript(script);
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
