
package fluentwait;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.*;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaitMethodUsingLambda2 {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		 driver = new ChromeDriver();

		driver.get("https://www.guru99.com/");

		
		WebElement webelement=getWebElement(By.xpath("//a[text()='JIRA']"));
		webelement.click();
	}

	private static WebElement getWebElement(By by) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(25));
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.
		// Using Java8 Lambda Expression
		Function<WebDriver, WebElement> function = dr -> {
			System.out.println("Checking for the object");
			WebElement element = dr.findElement(by);
			if (element != null && element.isDisplayed()) {
				System.out.println("A new dynamic object is found.");
			}
			return element;
		};

		return wait.until(function);
	}
}