package downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DownloadFile_FireFox {
 
	public static void main(String[] args) {
	    
		System.setProperty("webdriver.gecko.driver", "/Users/uname/sel/geckodriver");
		String downloadFilepath = "/Users/uname/sel/";
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.helperApps.alwaysAsk.force", false);
		options.addPreference("browser.download.dir", downloadFilepath); 
		options.addPreference("browser.download.defaultFolder",downloadFilepath); 
		options.addPreference("browser.download.manager.showWhenStarting", false);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk","multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		
		FirefoxDriver driver = new FirefoxDriver(options);
		driver.get("http://www.seleniumhq.org/download/");
        driver.findElement(By.linkText("32 bit Windows IE")).click();  
	}
}