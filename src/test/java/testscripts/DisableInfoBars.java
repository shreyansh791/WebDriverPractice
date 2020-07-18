package testscripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableInfoBars {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true); // First Way

		options.addArguments("--disable-infobars"); // disable infobars
		// System.out.println(options.getBrowserName()); // display browser name

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Title is " + driver.getTitle());

		driver.quit();

	}
}
