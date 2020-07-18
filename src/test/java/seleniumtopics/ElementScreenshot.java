package seleniumtopics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class ElementScreenshot extends AbstractWebDriverEventListener {
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

	WebDriver driver=new ChromeDriver();
//	driver.get("http://www.google.com");
//	
//	//driver.findElement(By.name("q")).sendKeys("हिन्दी शब्द");
//	
//	String[] strings = {"str1", "str2", "str3"};
//	
//	driver.findElement(By.name("q")).sendKeys(strings);
//	
//	WebElement ele = driver.findElement(By.id("hplogo"));
//	
	List<String> windowHandles = (List<String>) driver.getWindowHandles();

	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File screenshotLocation = new File("GoogleLogo_screenshot1.png");
	
	
	FileHandler.copy(screenshot, screenshotLocation);  // New Line of code from Selenium 3 

}
}
