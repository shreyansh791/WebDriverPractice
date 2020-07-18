package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void test2()
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
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver);

	}
	}
