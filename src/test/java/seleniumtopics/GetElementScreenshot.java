package seleniumtopics;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class GetElementScreenshot {
public static void main(String[] args) throws IOException {
	
	
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

	WebDriver driver=new ChromeDriver();
	driver.get("http://www.google.com");
	WebElement ele = driver.findElement(By.id("hplogo"));

	// Get entire page screenshot
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	BufferedImage  fullImg = ImageIO.read(screenshot);

	// Get the location of element on the page
	Point point = ele.getLocation();

	// Get width and height of the element
	int eleWidth = ele.getSize().getWidth();
	int eleHeight = ele.getSize().getHeight();

	// Crop the entire page screenshot to get only element screenshot
	BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
	    eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png", screenshot);

	// Copy the element screenshot to disk
	File screenshotLocation = new File("GoogleLogo_screenshot3.png");
		FileHandler.copy(screenshot, screenshotLocation);  // New Line of code from Selenium 3 

	
}
}
