package seleniumtopics1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMinimizeWindow {
public static void main(String[] args) throws IOException {

	/*Hashtable table=new Hashtable();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	driver.manage().window().setPosition(new Point(0, -2000));
	System.out.println("done.");
	*/
	
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

	
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.actitime.com");
	File srcFile = driver.findElement(By.xpath("//div[text()='Login ']")).getScreenshotAs(OutputType.FILE);
	Files.copy(srcFile.toPath(), new File("./Screenshots/logout.png").toPath());
	driver.close();
}
}
