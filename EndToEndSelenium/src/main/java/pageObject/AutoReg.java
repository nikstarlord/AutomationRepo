package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutoReg {
    public WebDriver driver;

    public AutoReg(WebDriver driver) {
        this.driver = driver;
    }

    By lan = By.id("msdd");
    By list = By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a");

    public WebElement getLan(){
        return driver.findElement(lan);
    }

    public List<WebElement> getList(){
        return driver.findElements(list);
    }
}
