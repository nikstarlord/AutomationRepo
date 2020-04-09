package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwitchWindow {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        ch.acceptInsecureCerts();
        ChromeOptions c =new ChromeOptions();
        c.merge(ch);
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver(c);
        driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
       // Thread.sleep(2000);
       // driver.findElement(By.xpath("//a[@rel='v:url']")).click();
        Thread.sleep(2000);
        WebElement link=driver.findElements(By.xpath("//span[@class='menu-text']")).get(4);
        System.out.println(link.getText());
        Actions act = new Actions(driver);
        //String seq = Keys.chord(Keys.CONTROL,Keys.ENTER);
        act.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();

    }
}
