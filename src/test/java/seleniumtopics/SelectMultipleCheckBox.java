package seleniumtopics;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectMultipleCheckBox {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String xpath = "//input[@type='checkbox']/following-sibling::label"; // u have to write this xpath in Page Class.
		//  step file  selectMultipleCheckBoxes(CustomerCreation.xpath, checkBoxToBeSelected);
		selectMultipleCheckBoxes(xpath, "");
	}

	public static void selectMultipleCheckBoxes(String checkBoxProperty, String checkBoxesToSelect) {
		System.out.println("CheckBox Property :: "+checkBoxProperty);
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath(checkBoxProperty));
	
		System.out.println("Checkboxes Size - " + allCheckBoxes.size());
		if(allCheckBoxes.size()>0)
		{
		if (checkBoxesToSelect.contains(",")) {
			String[] checkBoxesArray = checkBoxesToSelect.split(",");
			for (int i = 0; i < checkBoxesArray.length; i++) {
				for (int j = 0; j < allCheckBoxes.size(); j++) {

					if (checkBoxesArray[i].equalsIgnoreCase(allCheckBoxes.get(j).getText())) {
						//input[@type='checkbox']/following-sibling::label[contains(text(),'Cricket')]/preceding-sibling::input
						System.out.println(checkBoxProperty + "[contains(text(),'" + checkBoxesArray[i] + "')]"
								+ "/preceding-sibling::input");
						driver.findElement(By.xpath(checkBoxProperty + "[contains(text(),'" + checkBoxesArray[i] + "')]"
								+ "/preceding-sibling::input")).click();
						break;
					}
				}

			}
		} else if (!checkBoxesToSelect.equals("")) {
			for (int j = 0; j < allCheckBoxes.size(); j++) {

				if (checkBoxesToSelect.equalsIgnoreCase(allCheckBoxes.get(j).getText())) {
					System.out.println(
							checkBoxProperty + "[contains(text(),'" + checkBoxesToSelect + "')]" + "/preceding-sibling::input");
					driver.findElement(By.xpath(
							checkBoxProperty + "[contains(text(),'" + checkBoxesToSelect + "')]" + "/preceding-sibling::input"))
							.click();
					break;
				}
			}

		} else {
			System.out.println("No Checkbox to select!");
		}
		}
	}
}
