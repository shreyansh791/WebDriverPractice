package seleniumtopics;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class DownloadFile {

	WebDriver driver = null;
	File folder = null;

	@BeforeMethod
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		try {
			folder.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

		Map<String, Object> prefs = new LinkedHashMap<>();
		prefs.put("profile.default_content_settings.popups", 0); // Please dont display any pop-up
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(options);

	}

	@Test
	public void downloadTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");

		driver.findElement(By.linkText("some-file.txt")).click();
	
	Thread.sleep(2000);
	
	File listFiles[]=folder.listFiles();
	
	//Assert.assertEquals(listFiles.length, is(not(0)));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		for (File tempFile : folder.listFiles()) {

			tempFile.delete();

		}
		folder.delete();

	}
}
