package seleniumtopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This example shows how to use WebDriverManager class and no need to use
 * System.setProperty("","");
 * 
 * @author Shreyansh Jain
 *
 */
public class WebDriverManagerDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
}
