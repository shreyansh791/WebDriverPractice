package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

public class ExtraLocators {
	WebDriver driver = null;

	@Test
	public void byAllWorking() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(new ByAll(By.id("lst-ib"), By.name("q"))).sendKeys("Shreyansh Jain");
		driver.findElement(new ByIdOrName("lst-ib")).sendKeys("Shreyansh Jain");
	}
}
