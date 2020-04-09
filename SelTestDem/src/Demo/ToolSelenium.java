package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ToolSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.toolsqa.com/automation-practice-switch-windows/");
        List<WebElement> ls=driver.findElements(By.xpath("//span[contains(text(),'Blogs')]"));
        WebElement blogHeader = ls.get(0);
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(blogHeader).build().perform();
    }
}
