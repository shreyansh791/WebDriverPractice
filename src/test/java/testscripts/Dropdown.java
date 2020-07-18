package testscripts;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.delta.com/flight-search/book-a-flight?Log=1&mkcpgn=SEzzzGGatlCSpriBD&clickid=8b32dd89-61dd-4687-9732-d6bffacd4ed2&tracking_id=284x4088563&s_kwcid=TC%7C8489%7Cdelta%7C%7CS%7Ce%7C2376344082934");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("showbestfare-val")).click();
		selectDropdownValue(driver.findElements(By.xpath("//span[@id='showbestfare-val']/following::ul[1]/li")),"Main Cabin");

	}

	public static void selectDropdownValue(List<WebElement> list, String text) {
		System.out.println("list.size() is "+list.size());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(text)) {
				list.get(i).click();
			}
		}
	}
}
