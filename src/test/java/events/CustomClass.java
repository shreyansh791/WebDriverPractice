package events;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CustomClass {
	static EventFiringWebDriver driver = null;
	static WebDriver dr = null;

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		dr = new ChromeDriver();
		driver = new EventFiringWebDriver(dr);
		driver.register(new EventListener());
	
		driver.get("http://automate-apps.com/");
        System.out.println(driver.getTitle());
        Actions action = new Actions(driver);
       
        WebElement element = driver.findElement(By.partialLinkText("Selenium Questions"));
       
        /*action.moveToElement(element).contextClick(element).build().perform();
        Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		
		

	}
}
