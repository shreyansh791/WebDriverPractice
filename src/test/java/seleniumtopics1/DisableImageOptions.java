package seleniumtopics1;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

public class DisableImageOptions {
public static void main(String[] args) {
	/*WebDriverManager.chromedriver().setup();
	
	ChromeOptions options=new ChromeOptions();
	
	disableImageChrome(options);
	WebDriver driver=new ChromeDriver(options);
	*/
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions firefoxOptions = new FirefoxOptions();
	disableImageFirefox(firefoxOptions);
	WebDriver driver=new FirefoxDriver(firefoxOptions);
	
	driver.get("https://www.flipkart.com/");
	String title = driver.getTitle();
	System.out.println(title);
}


private static void disableImageFirefox(FirefoxOptions options) {
	FirefoxProfile profile=new FirefoxProfile();
	profile.setPreference("permissions.default.image",2);
	options.setProfile(profile);
	options.setCapability(FirefoxDriver.PROFILE,profile);
}

private static void disableImageChrome(ChromeOptions options) {
	HashMap<String,Object> images=new HashMap<>();
	images.put("images",2);
	HashMap<String,Object> preferences=new HashMap<>();
	preferences.put("profile.default_content_setting_values", images);
	options.setExperimentalOption("prefs", preferences);
	
}
}
