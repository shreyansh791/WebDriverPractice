package testautomationguru;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FirstTest {

@Test
public void demo() throws JsonParseException, JsonMappingException, IOException
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"browser_exe"+File.separator+"chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://form.jotform.com/81665408084158");
	
	
	String path = System.getProperty("user.dir")+File.separator+"testdata"+File.separator+"pageobjects.json";
	Map<String, Object> result = new ObjectMapper().readValue(new File(path), LinkedHashMap.class);
	

	//Iterate all the keys from the map & enter data
	result.entrySet()
	        .stream()
	        .forEach(entry -> {
	            //find all the elements for the given name / map key
	        	
	            List<WebElement> elements = driver.findElements(By.name(entry.getKey()));

	            //scroll into view - remove this if you do not need it
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.get(0));

	            //element is found already, scrolled into view
	            //now it is time for entering the value
	            ElementsHandler.handle(elements, entry.getValue());
	        });
	
}
}
