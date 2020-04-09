package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FrameTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","/home/nikhil/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
        WebDriver driver =  new FirefoxDriver();

        driver.get("http://demo.automationtesting.in/Frames.html");
        /*driver.switchTo().frame("singleframe");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("hello inside");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[href='#Multiple']")).click();
        WebElement frame = driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']"));
        driver.switchTo().frame(frame);
       // WebElement frameinside = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']//iframe[@src='SingleFrame.html']"));
        WebElement ls =driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
        driver.switchTo().frame(ls);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Hello multiple");*/
        System.out.println(driver.findElements(By.tagName("iframe")).size());
    }
}
