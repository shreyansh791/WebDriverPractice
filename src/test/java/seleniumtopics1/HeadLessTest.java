package seleniumtopics1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessTest {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	//options.addArguments("--headless");
	options.addArguments("start-maximized");
	options.addArguments("disable-infobars");
	//Load Default/Custom Chrome Profile :-
	options.addArguments("user-data-dir=C:/Users/Shreyansh Jain/AppData/Local/Google/Chrome/User Data");
	ChromeDriver driver=new ChromeDriver(options);
	driver.get("https://www.google.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());	
	Thread.sleep(3000);
	driver.quit();
	
}
}
