package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumEasyDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","/home/nikhil/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
        WebDriver driver =  new FirefoxDriver();
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//*[@onclick='myAlertFunction()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@onclick='myConfirmFunction()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//*[@onclick='myPromptFunction()']")).click();
        driver.switchTo().alert().sendKeys("Nikhil");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
}
