package seleniumtopics1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteWebDriverDemo {
public static void main(String[] args) {
	
	System.out.println("Execution Starts");
	// Setting chrome driver property and opening chrome browser
	// System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver = new ChromeDriver();
	System.out.println("Browser opened.");
	driver.get("https://www.guru99.com/");
	// We need to downcast WebDriver reference varaible to use JavascriptExecutor
	// methods

	WebElement element = driver.findElement(By.xpath("(//a[text()='Informatica'])[3]"));
	
	driver.executeScript("arguments[0].scrollIntoView()",element);
	System.out.println("Working...");
	}
}
