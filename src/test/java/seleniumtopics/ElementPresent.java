package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPresent {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.google.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// System.out.println(isElementPresent1("xpath=//*[@name='qq']"));
		new WebDriverWait(driver, 15).until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//input[@name='q']")));
		
		WebElement findElement = driver.findElement(By.xpath("//input[@name='q']"));
		
		System.out.println(findElement.toString());
		
		Thread.sleep(5000);

	}

	/*private static boolean isElementPresent(By by) {
		try {
			int size = driver.findElements(by).size();
			System.out.println(size);
			driver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}*/
	
	private static boolean isElementPresent1(String property) {
		try {
			Get_Element(property);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
			return false;
		}
	}

	private static WebElement Get_Element(String property) {
		
	return driver.findElement(By.xpath(property.substring(property.indexOf("=")+1)));
		
	}
	
	

}
