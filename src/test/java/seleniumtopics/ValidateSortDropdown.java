package seleniumtopics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateSortDropdown {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.id("month")));
		List<WebElement> monthsDropdown = select.getOptions();
		List<String> actual = new ArrayList<>();
		for (WebElement element : monthsDropdown) {
			actual.add(element.getText());
		}
		List<String> expected = new ArrayList<>(actual);
		Collections.sort(expected);
		System.out.println("expected - " + expected);
		System.out.println("actual - " + actual);
		Assert.assertEquals(actual, expected,"Mismatch");
	}
}
