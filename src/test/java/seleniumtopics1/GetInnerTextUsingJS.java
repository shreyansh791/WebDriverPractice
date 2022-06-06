package seleniumtopics1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GetInnerTextUsingJS {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/shreyansh.jain/Desktop/normalize.html");
        List<WebElement> element = driver.findElements(By.xpath("//label"));
        element.stream()
                .forEach(i -> System.out.println(" GET ATTR :: " + i.getAttribute("textContent").trim()
                ));
        System.out.println(" ===================================================================");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Object> collect = element.stream()
                .map(i -> js.executeScript("return arguments[0].childNodes[0].textContent",
                        element.get(atomicInteger.getAndAdd(1))).toString().trim()).
                        collect(Collectors.toList());

    }
}