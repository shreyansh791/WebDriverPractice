package seleniumtopics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingWebDriverInstanceWithMultipleThreads implements Runnable {

	/*public static WebDriver driver;  bad way of coding*/
	public static LinkedHashMap<Integer,WebDriver> maps=new LinkedHashMap<>();
	

	public static WebDriver getCurrentDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			int id = (int) Thread.currentThread().getId();
			System.out.println("id is "+id);
			if(!maps.containsKey(id))
			{
			WebDriver driver=new ChromeDriver();
			maps.put(id,driver);
			return driver;
			}
			else
			{
				return maps.get(id);
			}
			
		}
		return null;
	}
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++)
		{
			Thread thread=new Thread(new HandlingWebDriverInstanceWithMultipleThreads());
			thread.start();	
		}
		
	}
	@Override
	public void run() {
		WebDriver currentDriver = getCurrentDriver("chrome");
		System.out.println("currentDriver - "+ currentDriver);
		currentDriver.close();
	}
}


