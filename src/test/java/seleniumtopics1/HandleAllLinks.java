package seleniumtopics1;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class HandleAllLinks {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	String xpath="//h3[contains(text(),'Selenium')]";
	List<WebElement> allLinks = driver.findElements(By.xpath(xpath));
	System.out.println("allLinks.size is "+allLinks.size());
	for(int i=0;i<allLinks.size();i++)
	{
		//List<WebElement> allLinks1=driver.findElements(By.xpath("//h3[contains(text(),'Selenium')]"));
		WebElement webElement;
		try {
			System.out.println("Try... "+ i);
		webElement = allLinks.get(i);
		webElement.click();
		}catch (StaleElementReferenceException e) {
			System.out.println("Catch ... "+ i);
			//WebElement element = getElement(driver,By.xpath(xpath));
			/*element.click();*/
			List<WebElement> allLinks1=driver.findElements(By.xpath("//h3[contains(text(),'Selenium')]"));
			webElement = allLinks1.get(i);
			webElement.click();
		}
		
		System.out.println("i is "+ i +" and title is "+ driver.getTitle());
		driver.navigate().back();
	}   
	
}
public static WebElement getElement(WebDriver driver,final By by)
{
	
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	wait.pollingEvery(java.time.Duration.ofSeconds(1));
	wait.withTimeout(java.time.Duration.ofSeconds(20));
	wait.ignoring(StaleElementReferenceException.class);

		WebElement someElement = wait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		        return driver.findElement(by);
		    }
		});
		return someElement;	
}
}
