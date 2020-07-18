package seleniumtopics1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchContextDemo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
	
	SearchContext driver = new ChromeDriver();
	WebDriver dr=(WebDriver) (driver);
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	dr.get("https://www.google.com/");
	System.out.println(dr.getTitle());
	
}
}
