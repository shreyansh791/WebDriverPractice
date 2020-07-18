package testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZoomIn {
	public static void main(String[] args) throws InterruptedException, AWTException {
		/*System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();*/
		
		
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		Robot robot = new Robot();
		 System.out.println("About to zoom in");
		 for (int i = 0; i < 3; i++) { 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_ADD);
		 robot.keyRelease(KeyEvent.VK_ADD);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 }
		Thread.sleep(1000);
		 System.out.println("About to zoom out");
		 for (int i = 0; i < 3; i++) {
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 }
		 
		 // 2nd way
		 
		 /*JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='50%'");

			js.executeScript("document.body.style.zoom='150%'");
			*/
		 

	}

}
