package testscripts;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class HandlingMMTCalendar {
static int count=0;	

	public static void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException
	{
		//Clicking on calendar to open calendar widget
		calendar.click();
		
		// Retrieving current year value
		String currentYear= driver.findElement(By.xpath("//div[@class='dl-datepicker-title']/span[contains(@class,'dl-datepicker-year')]")).getText();
		System.out.println("currentYear - "+currentYear);
		// Click on Next arrow till we get desired year
		if(!currentYear.equals(year))
		{
			do{
				driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();
			}while(!driver.findElement(By.xpath("//div[@class='dl-datepicker-title']/span[contains(@class,'dl-datepicker-year')]")).getText().equals(year));
			
		}
		
		// Select desired month after selecting desired year
		
		loop:
		while(count<12)
		{
			List<WebElement> monthList=driver.findElements(By.xpath("//div[@class='dl-datepicker-title']/span[contains(@class,'dl-datepicker-month')]"));
		for(int i=0;i<monthList.size();i++)
		{
		String currentMonth=monthList.get(i).getText();
			 if(!currentMonth.equalsIgnoreCase(monthName))
				{
				 i++;
				 currentMonth=monthList.get(i).getText();
				 if(!currentMonth.equalsIgnoreCase(monthName))
				 {
					 
					 driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();
					 count++;
				}else
				{
					break loop;
				}
		}
			 else
			 {
				 break loop;
			 }
		}
		}
		
		//get java month number for desired month
		
		int javaMonthInt= HandlingMMTCalendar.getMonthJavaInt(monthName);
		
		// Find dates of desired month only
		
		List<WebElement> allDateOfDesiredMonth= driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table/tbody[1]//td[(@class=' ' or @class=' ui-datepicker-week-end ' ) and @data-month='"+javaMonthInt+"']"));
		for(WebElement d:allDateOfDesiredMonth )
		{
			if(d.getText().trim().equals(day))
			{
				d.click();
				break;
			}
		}
		
		
		
	}
	
	// Code to get java month number
	public static int getMonthJavaInt(String monthName) throws ParseException 
	{

		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	public static void main(String[] args) throws ParseException {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.delta.com/flight-search/book-a-flight");
		
		// Locating departure date calendar
		WebElement departCal= driver.findElement(By.id("input_departureDate_1"));
		HandlingMMTCalendar.selectDate(departCal, "2018", "December", "11", driver);
		
		
		
		
		

	}
}
