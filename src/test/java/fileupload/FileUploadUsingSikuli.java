package fileupload;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadUsingSikuli {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='btn btn-primary btn-file']")).click();
		
		Screen screen = new Screen();
		Pattern fileNameInput = new Pattern(System.getProperty("user.dir")+File.separator+"FileOpenInput.PNG");
		Pattern openButton = new Pattern(System.getProperty("user.dir")+File.separator+"OpenButton.PNG");
		try {
			screen.type(fileNameInput, System.getProperty("user.dir")+File.separator+"FileOpenInput.PNG");
			screen.click(openButton);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
