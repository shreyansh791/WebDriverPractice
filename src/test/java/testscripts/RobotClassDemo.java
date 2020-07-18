package testscripts;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RobotClassDemo {
	@Test
	public void robotDemo() throws AWTException, InterruptedException {
		System.out.println("Robot class demo started....");
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Robot r = new Robot();
		/*r.mouseMove(35,35);
	    r.mousePress( InputEvent.BUTTON1_MASK );
	    r.mouseRelease( InputEvent.BUTTON1_MASK );
	    Thread.sleep(5000);
	    r.mousePress( InputEvent.BUTTON1_MASK );
	    r.mouseRelease( InputEvent.BUTTON1_MASK );
	    */
	    
	    Color color = r.getPixelColor(20, 20);

	    System.out.println("Red   = " + color.getRed());
	    System.out.println("Green = " + color.getGreen());
	    System.out.println("Blue  = " + color.getBlue());
	    

	}
}
