package seleniumtopics;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDebugger {

	public static void main(String[] args) throws InterruptedException {

		// chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\autoprofile"
		ChromeOptions cp = new ChromeOptions();
		cp.setExperimentalOption("debuggerAddress", "127.0.0.1:9223");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		ChromeDriver driver = new ChromeDriver(cp);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("nhj");
		Thread.sleep(2000);

		System.out.println(driver.getTitle());

	}
}
