package events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener extends AbstractWebDriverEventListener

{

	

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("Just before beforeNavigateTo " + arg0);
	
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Just before beforeScript " + arg0);
		
	}


	
}