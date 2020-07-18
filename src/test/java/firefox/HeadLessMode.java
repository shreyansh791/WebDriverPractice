package firefox;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class HeadLessMode {
	@Test
	public void runHeadLess() {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "geckodriver.exe");

		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("ShreyanshsProfile");

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(myprofile);
		WebDriver driver = new FirefoxDriver(firefoxOptions);

		driver.get("http://demo-store.seleniumacademy.com/");

		System.out.println(driver.getTitle());
	}

}
