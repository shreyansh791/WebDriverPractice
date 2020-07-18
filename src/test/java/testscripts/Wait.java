package testscripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
	
	
	WebDriver driver = new ChromeDriver();
	driver.get(
			"http://www.itgeared.com/demo/1506-ajax-loading.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[contains(text(),'Click to load')]")).click();
	// This example proved why Explicit wait is necessary.
	WebDriverWait wait=new WebDriverWait(driver, 30);
	WebElement ele=driver.findElement(By.id("results"));
	System.out.println("Element Displayed - "+ele.isDisplayed());
	wait.until(ExpectedConditions.visibilityOf(ele));
	System.out.println("Element Displayed - "+ele.isDisplayed());
	System.out.println("Text from UI - "+ele.getText());
	
	
}
}
