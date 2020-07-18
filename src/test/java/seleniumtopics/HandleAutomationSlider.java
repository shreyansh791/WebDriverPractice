package seleniumtopics;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleAutomationSlider {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"browser_exe"+File.separator+"geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://demo.automationtesting.in/Slider.html");
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement slider=driver.findElement(By.cssSelector("a[class*='ui-slider-handle']"));
	Actions actions=new Actions(driver);
	
	actions.dragAndDropBy(slider,540,400).release().build().perform();
	slider.click();
	
	
	
}
}
