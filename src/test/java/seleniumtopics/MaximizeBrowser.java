package seleniumtopics;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximizeBrowser {
public static void main(String[] args) {
	ChromeOptions options = new ChromeOptions();
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--profile-directory=Profile 2");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.google.com/");
}
}
