package seleniumtopics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllAnnotations {
	WebDriver driver;
@FindAll({
	@FindBy(how=How.NAME,using="q"),
	@FindBy(css="input[title='Search']")
	
})
private WebElement ele;
FindAllAnnotations(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void enterData()
{
ele.sendKeys("Yes Its Working...");	
}
}
