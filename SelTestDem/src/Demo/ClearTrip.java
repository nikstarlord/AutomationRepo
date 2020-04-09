package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        Select Adlt = new Select(driver.findElement(By.id("Adults")));
        Adlt.selectByIndex(4);
        Select chld = new Select(driver.findElement(By.id("Childrens")));
        chld.selectByIndex(3);
        Select infnt = new Select(driver.findElement(By.id("Infants")));
        infnt.selectByIndex(3);
        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Air");
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("Searchbtn")).click();
        //driver.findElement(By.id("Searchbtn")).sendKeys(Keys.ENTER);
       // driver.findElement(By.id(""))
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
    }
}
