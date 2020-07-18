package fileupload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSendKeys {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("input-4")).sendKeys(System.getProperty("user.dir")
				+File.separator+"GoogleLogo_screenshot.png");
		
	}
}
