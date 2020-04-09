import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LanguageTest {
    @Test
    public void langTest() throws IOException {
        System.setProperty("webdriver.gecko.driver","/home/nikhil/Downloads/Softwares/geckodriver-v0.26.0-linux64/geckodriver");
        WebDriver driver =  new FirefoxDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/nikhil/EndToEndSelenium/src/main/java/resources/data.properties");
        prop.load(fs);
        List<String> langInput = Stream.of(prop.getProperty("language").split(",")).collect(Collectors.toList());
        driver.findElement(By.id("msdd")).click();
        List<WebElement> lnList = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
        int inputSize = langInput.size();
        int listSize = lnList.size();
        /*for(int i=0;i<inputSize;i++){
            for(int j=0;j<listSize;j++){
                String str = lnList.get(j).getText();
                if(str.equals(langInput.get(i))){
                    lnList.get(j).click();
                }
            }
        }*/
        for(int i=0;i<listSize;i++ ){
            String st = lnList.get(i).getText();
            System.out.println(st);
        }
    }
}




 class SeleniumEasyDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/Softwares/chromedriver_linux64/chromedriver");

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
        //driver.findElement(By.id("printMe")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@class='getall-selected']")).getText());
        //driver.findElement(By.id("printAll")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@class='getall-selected']")).getText());
        List<WebElement> options = drp.getAllSelectedOptions();
        for(WebElement option : options) {
            System.out.println(option.getText());
        }

    }
}

