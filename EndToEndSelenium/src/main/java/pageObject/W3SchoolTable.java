package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class W3SchoolTable {
    public WebDriver driver;

    public W3SchoolTable(WebDriver driver){
        this.driver=driver;
    }

    By table = By.xpath("//table[@id='customers']//tr/td[1]");

    public List<WebElement> getTable(){
        return driver.findElements(table);
    }
}
