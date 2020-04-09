import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PopUpClose {
    @Test
    public void getClose(){
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/Softwares/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/community/3409/how-to-close-browser-popup-in-selenium-webdriver");
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement pop;
        pop=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close close-subscribe-section']/span[contains(text(),x)]")));
        pop.click();
    }
}
