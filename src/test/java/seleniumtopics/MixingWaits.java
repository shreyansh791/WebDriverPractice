package seleniumtopics;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingWaits {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	WebDriverWait wait=new WebDriverWait(driver, 40);
	System.out.println("Wait starts:"+new Date());
	try {
		wait.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("wrongname")));
	}catch (Exception e) {
		System.out.println("Unable to locate element.");
	}
	System.out.println("Wait ends:"+new Date());	
}
}
