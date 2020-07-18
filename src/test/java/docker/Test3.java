package docker;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test3 {

	@Test
	public void test3()
	{

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		
		URL url = null;
		try {
			url = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("https://www.yahoo.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver);
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("C:/error12.png"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		 

	}
	}

