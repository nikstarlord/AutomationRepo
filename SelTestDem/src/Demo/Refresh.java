package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Refresh {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
       // driver.findElement(By.id("username")).sendKeys("Nikhil");
        //driver.navigate().refresh();
        //System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Automation Demo Site')]")).getText());
        //String header = new String(driver.findElement(By.xpath("//*[contains(text(),'Automation Demo Test')]")).getText());
        String header=driver.findElement(By.xpath("//*[contains(text(),'Automation Demo Site')]")).getText();
        if(header.equals("Automation Demo Site")){
            System.out.println("Passed....");
        }
        else{
            System.out.println("Failed....");
        }
        driver.close();
    }
}
