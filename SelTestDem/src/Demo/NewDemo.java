package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        //driver.findElement(By.xpath("//option[@value='Sunday']/following-sibling::option[1]")).click();//Sibling Xpath
        driver.findElement(By.xpath("//option[@value='Sunday']/parent::select")).click();//Xpath from child to parent
        
    }
}
