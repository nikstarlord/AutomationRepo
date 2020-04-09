package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        List<WebElement>ls = driver.findElements(By.xpath("//div[@class='et_pb_text_inner']//table"));
        WebElement t2 = ls.get(1);
        List<WebElement> td3 = t2.findElements(By.xpath("//td[3]"));
        //System.out.println(td3.size());
        int no_of_employee=3;
        for(int i=no_of_employee;i<td3.size();i++){
            String item = t2.findElements(By.xpath("//td[3]")).get(i).getText();
            System.out.println(item);
        }
    }
}
