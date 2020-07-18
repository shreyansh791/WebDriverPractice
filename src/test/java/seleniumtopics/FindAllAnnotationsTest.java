package seleniumtopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllAnnotationsTest {
	WebDriver driver;
	@Test
	public void findAllDemo()
	{
	WebDriverManager.chromedriver().setup();
		
		  driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");	
		driver.manage().window().maximize();
		new FindAllAnnotations(driver).enterData();

	}
}
