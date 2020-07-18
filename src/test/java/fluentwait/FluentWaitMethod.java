


package fluentwait;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaitMethod extends RemoteWebDriver {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("C:\\Users\\Shreyansh Jain\\Desktop\\FluentWAIT\\fluentwaitcommand.html");

		getWebElement(driver);
	}
	

	private static void getWebElement(WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(java.time.Duration.ofSeconds(1));
		wait.withTimeout(java.time.Duration.ofSeconds(20));
		wait.ignoring(NoSuchElementException.class); // We need to ignore this
														// exception.

		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver dr) {
				System.out.println("Checking for the object!!");
				WebElement element = dr.findElement(By.xpath("//a[text()='dynamicText6']"));
				if (element != null) {
					System.out.println("A new dynamic object is found.");
				}
				return element;
			}
		};
		wait.until(function);
	}
}