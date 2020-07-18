package datepicker;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDateByJS2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
// ctl00$mainContent$txt_Fromdate
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver();


		driver.get("http://spicejet.com/");
		   
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    WebElement date = driver.findElement(By.name("ctl00$mainContent$txt_Fromdate"));
	    String dateVal= "22/11";
	    dateSelectByJS(date, driver, dateVal);
	    
		}	
		public static void dateSelectByJS(WebElement element, WebDriver driver, String dateVal)
		 {
			JavascriptExecutor JS = ((JavascriptExecutor)driver);
			JS.executeScript("arguments[0].setAttribute('value', '"+dateVal+"');", element);
			System.out.println("================");
		}
	


	
	}
