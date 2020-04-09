package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","/home/nikhil/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
        WebDriver driver =  new FirefoxDriver();
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        WebElement btn = driver.findElement(By.xpath("//button[@onclick='myAlertFunction']"));
        btn.click();

    }
}
