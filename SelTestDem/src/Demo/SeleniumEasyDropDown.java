package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumEasyDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Select drp  = new Select(driver.findElement(By.id("multi-select")));
        List<WebElement> ls = drp.getOptions();
        //System.out.println(ls);
        if(ls.size()>1){
            System.out.println("Multiselect");
        }
        else{
            System.out.println("Single Select");
        }
        //Fetching all options..
        for(int i=0;i<ls.size();i++){
            String str = ls.get(i).getText();
            System.out.println("Item:"+i+" is:"+str);
        }
        drp.selectByValue("New Jersey");
        drp.selectByValue("New York");
        drp.selectByValue("Texas");
        //drp.selectByValue("");
        driver.findElement(By.id("printMe")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='getall-selected']")).getText());
        driver.findElement(By.id("printAll")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='getall-selected']")).getText());
        drp.deselectAll();

    }
}
