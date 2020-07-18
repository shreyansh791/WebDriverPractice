package testscripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo2 {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		System.out.println("start "+ System.currentTimeMillis());
		ChromeOptions options = new ChromeOptions();
	//	options.setHeadless(true); // First Way
		
	//	options.addArguments("disable-infobar");
		
		
		/* options.addArguments("window-size=1400,800"); 
		 options.addArguments("headless");
		  2nd way */ 
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Title is " + driver.getTitle());
		long end=System.currentTimeMillis();
		System.out.println("end "+ System.currentTimeMillis());
		driver.quit();		
		System.out.println((end-start)/1000.0f);

	}
}
