package seleniumtopics;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Shreyansh Jain
 * Inspect tooltip in Firefox:
1. hover over tooltip (tooltip is shown)
2. hit CTRL-Shift-K (Windows), to open "Web Console"
3. type "debugger" (this will stop JS execution, so tooltip won't disappear)
4. open "Inspector" Tab, and inspect it. 
5. edit as necessary. note: changes to CSS will work immediately, even if execution of JavaScript is stopped
 */
public class HandlingToolTip {
public static void main(String[] args) {
	String baseUrl = "http://demo.guru99.com/test/tooltip.html";					
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");

	WebDriver driver = new ChromeDriver();			
    String expectedTooltip = "What's new in 3.2";					
    driver.get(baseUrl);					
    		
    WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));	
    WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));	
    String toolTip = getToolTip(download,toolTipElement,driver);
    System.out.println(toolTip);
}
public static String getToolTip(WebElement baseElement, WebElement tooltipElement, WebDriver driver)
{
	// Actions class object
	Actions action= new Actions(driver);
	// Explicit wait
	WebDriverWait wait= new WebDriverWait(driver,10);
	// Moving mouse cursor to base element to make tooltip visible
	action.moveToElement(baseElement).build().perform();
	// Wait till tooltip is visible/displayed
	WebElement tooltipTextEle=wait.until(ExpectedConditions.visibilityOf(tooltipElement));
	// Get tool tip using getText method
	String toolTip= tooltipTextEle.getText();
	// return tool tip
	return toolTip;
}
}
