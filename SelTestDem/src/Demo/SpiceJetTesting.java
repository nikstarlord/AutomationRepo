package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SpiceJetTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");
        //driver.findElement(By.id("ctl00_mai9nContent_rbtnl_Trip_0")).click();
        Actions act = new Actions(driver);
        List<WebElement>ls = driver.findElements(By.xpath("//div[@class='desktop-navLink']"));
        int length = ls.size();
        WebElement home_living = null;
        for(int i=0;i<length;i++){
            home_living = driver.findElements(By.xpath("//div[@class='desktop-navLink']")).get(i);
           // System.out.println(home_living.getText());
            if(home_living.getText().contains("HOME & LIVING")){
                //home_living=current;
                break;
            }
        }
        act.moveToElement(home_living).build().perform();
        List<WebElement> list = driver.findElements(By.xpath("//div[@data-group=\"home-&-living\"]//li[@class='desktop-oddColumnContent'][2]//ul//li"));
        int listSize = list.size();
        WebElement clock=null;
        //System.out.println(listSize);
        for(int i=0;i<listSize;i++){
            clock = driver.findElements(By.xpath("//div[@data-group=\"home-&-living\"]//li[@class='desktop-oddColumnContent'][2]//ul//li")).get(i);
            //System.out.println(clock.getText());
            if(clock.getText().contains("Clocks")){
                break;
            }
        }
        clock.click();
        if(driver.getTitle().contains("Clocks")){
            System.out.println("passed...");
        }
        else{
            System.out.println("Failed...");
        }


    }
}
