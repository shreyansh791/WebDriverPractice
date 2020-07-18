package testscripts;

import java.io.File;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCalender2 {
 // // Handling Calendar Which Has Year & Month As Drop down In Selenium
	public static void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException, InterruptedException
	{
		//Clicking on calendar to open calendar widget
		calendar.click();
		
		// Select year first
		// Since drop down has been created using SELECT tag, We can use Select class.
		
		WebElement yearDropDown= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText(year);
		
		Thread.sleep(2000);
		
		// Select Month
		
		WebElement monthDropDown= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth= new Select(monthDropDown);
		selectMonth.selectByVisibleText(monthName);
		
		// Select date
		
		WebElement date= driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a[text()="+day+"]"));
		date.click();
		
		// Printing selected date
		String selectedDate= calendar.getAttribute("value");
		System.out.println("Selected Date: "+selectedDate);
		
	//	driver.quit();
		
		
		
	}
	
	// Code to get java month number
	/*public static int getMonthJavaInt(String monthName) throws ParseException 
	{

		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}*/
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html");
		
		// Locating departure date calendar
		WebElement departCal= driver.findElement(By.id("datepicker"));
		HandleCalender2.selectDate(departCal, "2016", "Sep", "13", driver);
		
	}
}
